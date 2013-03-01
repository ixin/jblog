package mx.meido.jblog.post.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.meido.jblog.post.domain.Post;
import mx.meido.jblog.post.domain.PostStatus.PostStage;
import mx.meido.jblog.post.repository.PostRepository;
import mx.meido.jblog.post.service.PostService;
@Service("postService")
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository pr;
	@Override
	public int getPostCount(){
		return pr.getPostCount();
	}
	@Override
	public Post getNextPost(Post post){
		return pr.getNextPost(post);
	}
	@Override
	public Post getPreviousPost(Post post){
		return pr.getPreviousPost(post);
	}
	@Override
	public void createNewPost(Post post){
		pr.createNewPost(post);
	}
	@Override
	public void deletePost(long id){
		pr.deletePost(id);
	}
	@Override
	public void changePostStage(Post post){
		pr.changePostStage(post);
	}
	@Override
	public List<Post> getPostFromAndLimitWithTimeDesc(long from, int limit, String postStage){
		return pr.getPostFromAndLimitWithTimeDesc(from, limit, postStage);
	}
	@Override
	public Map<String, Object> getPost(long id) {
		return pr.getPost(id);
	}
}
