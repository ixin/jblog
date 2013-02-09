package mx.meido.jblog.post.domain;

import java.util.Date;

public class PostValue {
	private final String title;//
	private final String content;//内容
	private final String summary;//简介
	private final Date postTime;//发表时间
	
	public PostValue(String title, String content, String summary, Date postTime) {
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
	public Date getPostTime() {
		return postTime;
	}
}
