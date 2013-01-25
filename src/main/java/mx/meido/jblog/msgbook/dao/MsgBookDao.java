package mx.meido.jblog.msgbook.dao;

import java.util.List;
import java.util.Map;

import mx.meido.jblog.msgbook.model.Message;

public interface MsgBookDao {
 
	public List<Map<String, Object>> getMsgs();
	
	public Message getMsgByID(String id);
	
	public int saveMsg(Message msg);
	
	public int delMsgByID(String id);
	
}
