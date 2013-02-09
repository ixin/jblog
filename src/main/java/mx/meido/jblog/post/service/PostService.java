package mx.meido.jblog.post.service;

import java.util.List;

import mx.meido.jblog.post.domain.Post;
import mx.meido.jblog.post.domain.PostStatus.PostStage;
import mx.meido.jblog.post.repository.PostRepository;

public class PostService {
	private static PostRepository pr = new PostRepository();
	
	public int getPostCount(){
		return pr.getPostCount();
	}
	public Post getNextPost(Post post){
		return pr.getNextPost(post);
	}
	public Post getPreviousPost(Post post){
		return pr.getPreviousPost(post);
	}
	public void createNewPost(Post post){
		pr.createNewPost(post);
	}
	public void deletePost(long id){
		pr.deletePost(id);
	}
	public void changePostStage(Post post){
		pr.changePostStage(post);
	}
	public List<Post> getPostFromAndLimitWithTimeDesc(long from, int limit){
		return pr.getPostFromAndLimitWithTimeDesc(from, limit, PostStage.PUBLISH.getStage());
	}
}
