package web_crawling.news.vo;

import java.util.List;
import java.util.Queue;

public class NewsModelStructVO {
	private String name;
	private String url;
	private Queue<String> catPath;
	private Queue<String> subCatPath;
	private Queue<String> itemPath;
	private List<String> curPagePath;
	
	public NewsModelStructVO(String name, String url, Queue<String> catPath, Queue<String> subCatPath,
			Queue<String> itemPath, List<String> curPagePath) {
		super();
		this.name = name;
		this.url = url;
		this.catPath = catPath;
		this.subCatPath = subCatPath;
		this.itemPath = itemPath;
		this.curPagePath = curPagePath;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public Queue<String> getCatPath() {
		return catPath;
	}

	public Queue<String> getSubCatPath() {
		return subCatPath;
	}

	public Queue<String> getItemPath() {
		return itemPath;
	}

	public List<String> getCurPagePath() {
		return curPagePath;
	}
	
}//class