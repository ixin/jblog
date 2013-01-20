package mx.meido.jblog.msgbook.model;

import java.util.Date;

public class Message {
	private String id;
	private String title;
	private String content;
	private Date sendTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Message(String id, String title, String content, Date sendTime) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.sendTime = sendTime;
	}

	public Message() {
		super();
	}

}
