package mx.meido.jblog.post.domain;

import java.io.Serializable;
import java.util.HashMap;

public class PostStatus implements Serializable{
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
		PUBLISH("publish"), DRAFT("draft"), DEL("del");

		private String stage;
		public String getStage() {
			return stage;
		}
		private PostStage(String stage) {
			this.stage = stage;
		}
	}
}
