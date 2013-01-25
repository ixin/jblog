package mx.meido.jblog.msgbook.service.impl;

import java.util.List;
import java.util.Map;

import mx.meido.jblog.msgbook.dao.MsgBookDao;
import mx.meido.jblog.msgbook.model.Message;
import mx.meido.jblog.msgbook.service.MsgBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("msgBookService")
public class MsgBookServiceImpl implements MsgBookService {
	@Autowired
	private MsgBookDao msgBookDao;

	@Override
	public List<Map<String, Object>> getMsgs() {
		return msgBookDao.getMsgs();
	}

	@Override
	public Message getMsgByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveMsg(Message msg) {
		return msgBookDao.saveMsg(msg);
	}

	@Override
	public int delMsgByID(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
