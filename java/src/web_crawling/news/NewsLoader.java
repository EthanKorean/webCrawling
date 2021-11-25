package web_crawling.news;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import com.google.gson.Gson;

import util.general.FileReadUtil;
import web_crawling.news.helper.ListLinkSortHelper;
import web_crawling.news.vo.NewsModelStructVO;

public class NewsLoader implements ThreadListener{
	
	private String rootUrl;
	private NewsModelStructVO newsModelVO;
	private boolean ended;
	private Queue<Byte> jobQueue;
	
	public NewsLoader(){
		ended=false;
		jobQueue = new ArrayBlockingQueue<Byte>(100) ;
		InputStream is = ClassLoader.getSystemResourceAsStream("web_crawling/news/model/news.json");
		try {
			String newsModelFile = FileReadUtil.readTextToString(is);
			newsModelVO = new Gson().fromJson(newsModelFile,NewsModelStructVO.class);
			rootUrl=newsModelVO.getUrl();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		System.out.println(newsModelVO.getName());
		System.out.println(newsModelVO.getUrl());
		System.out.println(newsModelVO.getCatPath());
		System.out.println(newsModelVO.getCurPagePath());
		System.out.println(newsModelVO.getItemPath());
		System.out.println(newsModelVO.getSubCatPath());
	}//NewsLoader
	
	public void load() {
		ListLinkSortHelper catHelper = new ListLinkSortHelper(rootUrl);
		catHelper.sort(newsModelVO.getCatPath());
		
		List<String> catList = catHelper.getTextList();
		ListLinkSortHelper subCatHelper = null;
		
		String cat="";
		String link="";
		
		for(int i =0; i<catList.size();i++) {
			cat = catList.get(i);
			link = catHelper.getTextLinkMap().get(cat);
			subCatHelper = new ListLinkSortHelper(String.format("%s%s", rootUrl,link));
			subCatHelper.sort(newsModelVO.getSubCatPath());
			if(!subCatHelper.getTextList().isEmpty()) {
				searchItem(subCatHelper,cat);
			}//end if
		}//end for
	}//load
	
	public void searchItem(ListLinkSortHelper subCatHelper, final String cat) {
		jobQueue.add((byte)0);
		String subCat="";
		String link="";
		List<String> subCatList=subCatHelper.getTextList();
		for(int j =0; j < subCatList.size();j++) {
			subCat=subCatList.get(j);
			link=subCatHelper.getTextLinkMap().get(subCat);
		}//end for
		System.out.println(cat+":"+subCatHelper.getTextLinkMap());
	}//searchSubCategory

	@Override
	public void finish() {
		jobQueue.poll();
		if(jobQueue.isEmpty()) {
			ended=true;
		}//end if
	}//finish

	public boolean isEnded() {
		return ended;
	}//isEnded
	
}//class
