package mx.meido.jblog.post.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import mx.meido.jblog.post.dao.PostDao;
import mx.meido.jblog.post.domain.Post;

public class PostDaoSqlImpl extends JdbcDaoSupport implements PostDao {

	@Override
	public int getPostCount(String postStage) {
		return this.getJdbcTemplate().queryForInt("SELECT COUNT(1) FROM post WHERE postStage = ?", postStage);
	}

	@Override
	public Map<String, Object> getNextPost(long fromId, String postStage) {
		Map<String, Object> post = this.getJdbcTemplate().queryForMap("SELECT * FROM post WHERE id > ? and postStage = ? ORDER BY ID ASC", fromId, postStage);
		return post;
	}

	@Override
	public Map<String, Object> getPreviousPost(long fromId, String postStage) {
		Map<String, Object> post = this.getJdbcTemplate().queryForMap("SELECT * FROM post WHERE id > ? and postStage = ? ORDER BY ID DESC", fromId, postStage);
		return post;
	}

	@Override
	public void save(Post post) {
		String insert = "INSERT INTO post(postuser, title, content, summary, postTime, postStage) VALUES(?,?,?,?,?,?)";
		this.getJdbcTemplate().update(insert,
				post.getUser().getUsername(),
				post.getPostValue().getTitle(),
				post.getPostValue().getContent(), 
				post.getPostValue().getSummary(), 
				new java.sql.Date(post.getPostValue().getPostTime().getTime()), 
				post.getPostStatus().getPostStage().getStage());
	}

	@Override
	public void delete(long id) {
		this.getJdbcTemplate().update("DELETE FROM post WHERE id = ?", id);
	}

	@Override
	public void changePostStage(long id, String postStage) {
		this.getJdbcTemplate().update("UPDATE post SET postStage = ? WHERE id = ?", postStage, id);

	}

	@Override
	public List<Map<String, Object>> getPostFromAndLimitWithTimeDesc(long from, int limit, String postStage) {
		return this.getJdbcTemplate().queryForList("SELECT * FROM post WHERE postStage = ? LIMIT ? OFFSET ? ORDER BY id DESC", postStage, limit, from);
	}

}
