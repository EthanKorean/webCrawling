package web_crawling.model;

public enum NEWS_URL {
	
	NAVER("https://news.naver.com/");
	
	private String url;
	
	NEWS_URL(String url) {
		this.url=url;
	}//URLModel
	
	public String getUrl() {
		return url;
	}//getUrl

}//class
