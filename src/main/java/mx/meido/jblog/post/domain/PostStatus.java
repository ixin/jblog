package mx.meido.jblog.post.domain;

import java.util.HashMap;

public class PostStatus {
	private HashMap<String, String> postMeta;
	private PostStage postStage;
	public HashMap<String, String> getPostMeta() {
		return postMeta;
	}
	public void setPostMeta(HashMap<String, String> postMeta) {
		this.postMeta = postMeta;
	}
	public void setPostStage(PostStage postStage) {
		this.postStage = postStage;
	}
	public PostStage getPostStage() {
		return postStage;
	}
	
	public static enum PostStage{
		PUBLISH("publish"), DRAFT("draft");

		private String stage;
		public String getStage() {
			return stage;
		}
		private PostStage(String stage) {
			this.stage = stage;
		}
	}
}
