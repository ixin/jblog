package mx.meido.jblog.post.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import mx.meido.jblog.post.dao.PostDao;
import mx.meido.jblog.post.dao.impl.PostDaoSqlImpl;
import mx.meido.jblog.post.domain.Post;
import mx.meido.jblog.post.domain.Post.PostBuilder;
import mx.meido.jblog.post.domain.PostStatus.PostStage;
import mx.meido.jblog.user.dao.UserInfoDao;
import mx.meido.jblog.user.dao.impl.UserInfoDaoImpl;
import mx.meido.jblog.user.model.UserInfo;

public class PostRepository {
	private static PostDao pd = new PostDaoSqlImpl();
	private static UserInfoDao ud = new UserInfoDaoImpl();
	
	public int getPostCount(){
		String postStageString = PostStage.PUBLIC.getStage();
		return pd.getPostCount(postStageString);
	}
	public Post getNextPost(Post post){
		long fromId = post.getPostId();
		String postStageString = PostStage.PUBLIC.getStage();
		
		Map<String, Object> rs = pd.getNextPost(fromId, postStageString);
		Post.PostBuilder pb = new PostBuilder();
		pb.setPostId((long) rs.get("id"));
		pb.setPostStatus(null, PostStage.PUBLIC);
		UserInfo u = (UserInfo) ud.loadUserByUsername((String) rs.get("postuser"));
		java.sql.Date d = (java.sql.Date) rs.get("postTime");
		Date date = new Date(d.getTime());
		pb.setNewPostValue((String)rs.get("title"), (String)rs.get("content"), (String)rs.get("summary"), date, u);
		return pb.build();
	}
	public Post getPreviousPost(Post post){
		long fromId = post.getPostId();
		String postStageString = PostStage.PUBLIC.getStage();
		
		Map<String, Object> rs = pd.getPreviousPost(fromId, postStageString);
		
		Post.PostBuilder pb = new PostBuilder();
		UserInfo u = (UserInfo) ud.loadUserByUsername((String) rs.get("postuser"));
		java.sql.Date d = (java.sql.Date) rs.get("postTime");
		Date date = new Date(d.getTime());
		pb.setPostId((long) rs.get("id"))
			.setPostStatus(null, PostStage.PUBLIC)
			.setNewPostValue((String)rs.get("title"), (String)rs.get("content"), (String)rs.get("summary"), date, u);
		return pb.build();
	}
	public void createNewPost(Post post){
		pd.save(post);
	}
	public void deletePost(long id){
		pd.delete(id);
	}
	public void changePostStage(Post post){
		long postId = post.getPostId();
		String postStageString = post.getPostStatus().getPostStage().getStage();
		pd.changePostStage(postId, postStageString);
	}
	public List<Post> getPostFromAndLimitWithTimeDesc(long from, int limit, String postStage){
		List<Map<String, Object>> postsRequested = pd.getPostFromAndLimitWithTimeDesc(from, limit, postStage);
		List<Post> posts = new ArrayList<Post>();
		for(Map<String, Object> rs : postsRequested){
			Post.PostBuilder pb = new PostBuilder();
			UserInfo u = (UserInfo) ud.loadUserByUsername((String) rs.get("postuser"));
			java.sql.Date d = (java.sql.Date) rs.get("postTime");
			Date date = new Date(d.getTime());
			pb.setPostId((long) rs.get("id"))
				.setPostStatus(null, PostStage.PUBLIC)
				.setNewPostValue((String)rs.get("title"), (String)rs.get("content"), (String)rs.get("summary"), date, u);
			posts.add(pb.build());
		}
		return posts;
	}
}
