package web_crawling.naver.imple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.select.Elements;

import web_crawling.model.NEWS_URL;
import web_crawling.naver.News;

public class NaverNews extends News {


	public NaverNews() {
		super(NEWS_URL.NAVER);
	}//NaverNews
	
	@Override
	public void sort() {
		Elements divTag= super.doc.select("div#lnb");
		Elements ulTag= divTag.select("ul");
		Elements liTag= ulTag.select("li");
		Elements aTag=null;
		String categoryName="";
		String href="";
		for(int i =1; i<liTag.size();i++) {
			aTag= liTag.get(i).select("a");
			href=aTag.attr("href");
			categoryName=aTag.select("span.tx").text();
			categoryList.add(categoryName);
			categoryUrlMap.put(categoryName, href);
		}//end for
		
		System.out.println(categoryList);
		System.out.println(categoryUrlMap);
	}//sort
	
}//class
