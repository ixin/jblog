package mx.meido.jblog.post.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.meido.jblog.post.dao.PostDao;
import mx.meido.jblog.post.domain.Post;
import mx.meido.jblog.post.domain.Post.PostBuilder;
import mx.meido.jblog.post.domain.PostStatus.PostStage;
import mx.meido.jblog.user.dao.UserInfoDao;
import mx.meido.jblog.user.model.UserInfo;
@Repository("pr")
public class PostRepository {
	@Autowired
	private PostDao postDao ;
	@Autowired
	private UserInfoDao userInfoDao ;
	
	public int getPostCount(){
		String postStageString = PostStage.PUBLISH.getStage();
		return postDao.getPostCount(postStageString);
	}
	public Post getNextPost(Post post){
		long fromId = post.getPostId();
		String postStageString = PostStage.PUBLISH.getStage();
		
		Map<String, Object> rs = postDao.getNextPost(fromId, postStageString);
		Post.PostBuilder pb = new PostBuilder();
		pb.setPostId((long) rs.get("id"));
		pb.setPostStatus(null, PostStage.PUBLISH);
		UserInfo u = (UserInfo) userInfoDao.loadUserByUsername((String) rs.get("postuser"));
		java.sql.Date d = (java.sql.Date) rs.get("posttime");
		Date date = new Date(d.getTime());
		pb.setNewPostValue((String)rs.get("title"), (String)rs.get("content"), (String)rs.get("summary"), date, u);
		return pb.build();
	} 
	public Post getPreviousPost(Post post){
		long fromId = post.getPostId();
		String postStageString = PostStage.PUBLISH.getStage();
		
		Map<String, Object> rs = postDao.getPreviousPost(fromId, postStageString);
		
		Post.PostBuilder pb = new PostBuilder();
		UserInfo u = (UserInfo) userInfoDao.loadUserByUsername((String) rs.get("postuser"));
		java.sql.Date d = (java.sql.Date) rs.get("postTime");
		Date date = new Date(d.getTime());
		pb.setPostId((long) rs.get("id"))
			.setPostStatus(null, PostStage.PUBLISH)
			.setNewPostValue((String)rs.get("title"), (String)rs.get("content"), (String)rs.get("summary"), date, u);
		return pb.build();
	}
	public void createNewPost(Post post){
		postDao.save(post);
	}
	public void deletePost(long id){
		postDao.delete(id);
	}
	public Map<String, Object> getPost(long id){
		return postDao.getPost(id);
	}
	public void changePostStage(Post post){
		long postId = post.getPostId();
		String postStageString = post.getPostStatus().getPostStage().getStage();
		postDao.changePostStage(postId, postStageString);
	}
	public List<Post> getPostFromAndLimitWithTimeDesc(long from, int limit, String postStage){
		List<Map<String, Object>> postsRequested = postDao.getPostFromAndLimitWithTimeDesc(from, limit, postStage);
		List<Post> posts = new ArrayList<Post>();
		for(Map<String, Object> rs : postsRequested){
			Post.PostBuilder pb = new PostBuilder();
			if(((String)rs.get("postStage")).equals(PostStage.PUBLISH.getStage())){
				pb.setPostStatus(null, PostStage.PUBLISH);
			} else if(((String)rs.get("postStage")).equals(PostStage.DRAFT.getStage())){
				pb.setPostStatus(null, PostStage.DRAFT);
			}
			UserInfo u = (UserInfo) userInfoDao.loadUserByUsername((String) rs.get("postuser"));
			java.util.Date date = new java.util.Date(((java.sql.Timestamp) (rs.get("posttime"))).getTime());
			pb.setPostId((long) rs.get("id"))
				.setNewPostValue((String)rs.get("title"), (String)rs.get("content"), (String)rs.get("summary"), date, u);
			posts.add(pb.build());
		}
		return posts;
	}
}
