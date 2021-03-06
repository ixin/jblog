package mx.meido.jblog.post.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import mx.meido.jblog.post.dao.PostDao;
import mx.meido.jblog.post.domain.Post;

@Repository("postDao")
public class PostDaoSqlImpl extends JdbcDaoSupport implements PostDao {

	public int getPostCount(String postStage) {
		return this.getJdbcTemplate().queryForInt("SELECT COUNT(1) FROM post WHERE postStage = ?", postStage);
	}

	public Map<String, Object> getNextPost(long fromId, String postStage) {
		Map<String, Object> post = this.getJdbcTemplate().queryForMap("SELECT * FROM post WHERE id > ? and postStage = ? ORDER BY ID ASC", fromId, postStage);
		return post;
	}
 
	public Map<String, Object> getPreviousPost(long fromId, String postStage) {
		Map<String, Object> post = this.getJdbcTemplate().queryForMap("SELECT * FROM post WHERE id > ? and postStage = ? ORDER BY ID DESC", fromId, postStage);
		return post;
	} 
 
	public void save(Post post) {
		String insert = "INSERT INTO post(postuser, title, content, summary, postTime, postStage) VALUES(?,?,?,?,?,?)";
		this.getJdbcTemplate().update(insert,
				post.getUser().getUsername(),
				post.getPostValue().getTitle(),
				post.getPostValue().getContent(), 
				post.getPostValue().getSummary(), 
				new java.sql.Timestamp(post.getPostValue().getPostTime().getTime()), 
				post.getPostStatus().getPostStage().getStage());
	}

	public void delete(long id) {
		this.getJdbcTemplate().update("DELETE FROM post WHERE id = ?", id);
	}

	public void changePostStage(long id, String postStage) {
		this.getJdbcTemplate().update("UPDATE post SET postStage = ? WHERE id = ?", postStage, id);

	}

	public List<Map<String, Object>> getPostFromAndLimitWithTimeDesc(long from, int limit, String postStage) {
		StringBuffer sb = new StringBuffer("SELECT * FROM post WHERE 1 = 1 ");
		int paramsSize = 2;
		if(StringUtils.isNotBlank(postStage)){
			sb.append(" and postStage = ? ");
			paramsSize++;
		}
		sb.append(" ORDER BY id DESC LIMIT ? OFFSET ? ");
		//初始化参数数组
		Object[] params = new Object[paramsSize];
		//设置参数值
		paramsSize --;
		params[paramsSize] = from;
		paramsSize --;
		params[paramsSize] = limit;
		
		if(StringUtils.isNotBlank(postStage)){
			paramsSize --;
			params[paramsSize] = postStage;
		}
		return this.getJdbcTemplate().queryForList(sb.toString(), params);
	}

	public Map<String, Object> getPost(long id) {
		String sql = "select * from post where id = ? ";
		Map<String, Object> map = null;
		try{
			map = this.getJdbcTemplate().queryForMap(sql, id);
		}catch(DataAccessException e){
			
		}
		return map;
	}

}
