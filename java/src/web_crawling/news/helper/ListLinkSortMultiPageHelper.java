package web_crawling.news.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import util.general.CollectionsDeepCopy;
import util.general.StringUtil;
import util.general.model.DateTimeFormat;

/**
 * 특정  html에서 li 태그안에있는 링크,텍스트값을 소팅하는 객체
 * @author DaeHyeonKim
 */
public class ListLinkSortMultiPageHelper {
	private static final String A_TAG="a";
	private static final String LI_TAG="li";
	
	private List<String> textList;
	private Map<String,String> textLinkMap;
	private String url;
	private Document doc;
	private int page=0;
	private String date;
	private String cat;
	private String subCat;
	public ListLinkSortMultiPageHelper(String cat, String subCat, String url) {
		this.url=url;
		this.cat=cat;
		this.subCat=subCat;
		textList = new ArrayList<String>();
		textLinkMap = new HashMap<String, String>();
		page=1;
		date = StringUtil.getCurDateTime(DateTimeFormat.DATE_FORMAT1);
		connect();
	}//url
	
	private String remakeURL() {
		return String.format("%s&page=%d&date=%s", this.url,page,date);
	}//remakeURL
	
	private void connect() {
		try {
			doc = Jsoup.connect(remakeURL()).get();
			int realPage = Integer.parseInt(doc.select("div.paging").select("strong").text());
			System.out.println(cat+","+subCat+","+doc.select("div.paging").select("strong").text()+":"+remakeURL());
			if(realPage==page) {
				page++;
				connect();
			}//end if
		} catch (IOException e) {
			e.printStackTrace();
		} //end catch
	}//connect
	
	public void sort(Queue<String> pathQue) {
		Queue<String> copyQueu=  CollectionsDeepCopy.copy(pathQue);
		Elements liEls = searchList(copyQueu);
		List<String> lastPathList = new ArrayList<String>(copyQueu);
		for(int i =0 ; i<liEls.size();i++) {
			searchTextAndLink(liEls.get(i),lastPathList);
		}//end for
	}//sort
	
	private void searchTextAndLink(Element el, List<String> lastPathList) {
		String tag="";
		String href="";
		String text="";
		Elements els=null;
		int lastIdex=lastPathList.size()-1;
		for(int i =0 ; i < lastPathList.size();i++) {
			tag = lastPathList.get(i);
			els=el.select(tag);
			if(A_TAG.equals(tag)) {
				href=els.attr("href");
			}//end if
			
			if(lastIdex==i) {
				text=els.text();
				textList.add(text);
				textLinkMap.put(text,href);
				text="";
				href="";
			}//end if
		}//end for
	}//searchATag
	
	private Elements searchList(Queue<String> pathQue) {
		String tag="";
		Elements els=null;
		while(!pathQue.isEmpty()) {
			tag=pathQue.poll();
			
			if(els==null) {
				els=doc.select(tag);
			}else {
				els=els.select(tag);
			}//end else
			
			if(LI_TAG.equals(tag)) {
				break;
			}//end if
		}//end while
		return els;
	}//searchList

	public List<String> getTextList() {
		return textList;
	}

	public Map<String, String> getTextLinkMap() {
		return textLinkMap;
	}
	
}//public class
