package mx.meido.jblog.post.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import mx.meido.jblog.post.domain.Post;
import mx.meido.jblog.post.domain.PostStatus.PostStage;
import mx.meido.jblog.post.repository.PostRepository;

public interface PostService {
	
	public int getPostCount();
	public Post getNextPost(Post post);
	public Post getPreviousPost(Post post);
	public void createNewPost(Post post);
	public void deletePost(long id);
	public Map getPost(long id);
	public void changePostStage(Post post);
	public List<Post> getPostFromAndLimitWithTimeDesc(long from, int limit, String postStage);
}
