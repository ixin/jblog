package mx.meido.jblog.post.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.meido.jblog.post.domain.Post;
import mx.meido.jblog.post.repository.PostRepository;
import mx.meido.jblog.post.service.PostService;
@Service("postService")
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository pr;
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
	public List<Post> getPostFromAndLimitWithTimeDesc(long from, int limit, String postStage){
		return pr.getPostFromAndLimitWithTimeDesc(from, limit, postStage);
	}
	public Map<String, Object> getPost(long id) {
		return pr.getPost(id);
	}
}
