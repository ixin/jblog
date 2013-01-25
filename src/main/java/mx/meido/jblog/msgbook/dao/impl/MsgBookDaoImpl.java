package mx.meido.jblog.msgbook.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mx.meido.jblog.msgbook.dao.MsgBookDao;
import mx.meido.jblog.msgbook.model.Message;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class MsgBookDaoImpl extends JdbcDaoSupport implements MsgBookDao {
	
	@Override
	public List<Map<String, Object>> getMsgs() {
		String sql = "select * from message";
		return this.getJdbcTemplate().queryForList(sql);
	}

	@Override
	public Message getMsgByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveMsg(Message msg) {
		String sql = "insert into message values(?, ?, ?)";
		return this.getJdbcTemplate().update(sql, new Object[]{msg.getId(), msg.getTitle(), msg.getContent()});
	}

	@Override
	public int delMsgByID(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
