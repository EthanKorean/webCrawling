package web_crawling.naver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import web_crawling.model.NEWS_URL;

public abstract class News {
	
	private boolean connected;
	protected Document doc;
	protected List<String> categoryList;
	protected Map<String,String> categoryUrlMap;
	
	protected News(NEWS_URL newsUrl) {
		categoryList = new ArrayList<String>();
		categoryUrlMap = new HashMap<String, String>();
		if(connect(newsUrl.getUrl())) {
			sort();
		}//end if
	}//News
	
	private boolean connect(String url) {
		try {
			this.doc = Jsoup.connect(url).get();
			connected=true;
		}catch(IOException ioe) {
			ioe.printStackTrace();
			connected=false;
		}//end catch
		
		return connected;
	}//connect
	
	protected abstract void sort();
	
	public boolean isConnected() {
		return connected;
	}//isConnect

}
