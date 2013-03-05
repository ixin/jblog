package mx.meido.jblog.post.domain;

import java.io.Serializable;
import java.util.HashMap;

import mx.meido.jblog.user.model.UserInfo;

//@Model
public class Post implements Serializable{
	private long postId;
	private PostStatus postStatus;
	private PostValue postValue;
	private UserInfo user;
	  
	public long getPostId() { 
		return postId;
	}
	public PostValue getPostValue() {
		return postValue;
	}
	public PostStatus getPostStatus() {
		return postStatus;
	}
	public UserInfo getUser() {
		return user;
	}
	 
	public static class PostBuilder{
		private long postId;
		private PostStatus postStatus;
		private PostValue postValue;
		private UserInfo user;
		
		public PostBuilder(){};
		
		public PostBuilder setPostId(long postId) {
			this.postId = postId;
			return this;
		}
		public PostBuilder setNewPostValue(String title, String content, String summary, java.util.Date postTime, UserInfo user){
			this.postValue = new PostValue(title, content, summary, postTime);
			this.user = user;
			return this;
		}
		public PostBuilder setPostStatus(HashMap<String, String> postMeta, PostStatus.PostStage postStage){
			this.postStatus = new PostStatus();
			this.postStatus.setPostMeta(postMeta);
			this.postStatus.setPostStage(postStage);
			return this;
		}
		public Post build(){
			Post post = new Post();
			post.postId = this.postId;
			post.postStatus = this.postStatus;
			post.postValue = this.postValue;
			post.user = this.user;
			return post;
		}
		public PostBuilder setPost(Post post){
			this.postId = post.postId;
			this.postStatus = post.postStatus;
			this.postValue = post.postValue;
			this.user = post.user;
			return this;
		}
	}
}
