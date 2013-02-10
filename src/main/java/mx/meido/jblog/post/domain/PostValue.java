package mx.meido.jblog.post.domain;

import java.io.Serializable;

public class PostValue implements Serializable{
	private final String title;//
	private final String content;//内容
	private final String summary;//简介
	private final java.util.Date postTime;//发表时间
	
	public PostValue(String title, String content, String summary, java.util.Date postTime) {
		this.title = title;
		this.content = content;
		this.summary = summary;
		this.postTime = postTime;
	}
	
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getSummary() {
		return summary;
	}
	public java.util.Date getPostTime() {
		return postTime;
	}
}
