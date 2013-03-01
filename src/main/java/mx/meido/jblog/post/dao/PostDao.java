package mx.meido.jblog.post.dao;

import java.util.List;
import java.util.Map;

import mx.meido.jblog.post.domain.Post;

public interface PostDao {
	public int getPostCount(String postStage);
	public Map<String, Object> getNextPost(long fromId, String postStage);
	public Map<String, Object> getPreviousPost(long fromId, String postStage);
	public void save(Post post);
	public void delete(long id);
	public Map getPost(long id);
	public void changePostStage(long id, String postStage);
	public List<Map<String, Object>> getPostFromAndLimitWithTimeDesc(long from, int limit, String postStage);
}
