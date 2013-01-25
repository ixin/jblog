package mx.meido.jblog.msgbook.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.meido.jblog.msgbook.model.Message;
import mx.meido.jblog.msgbook.service.MsgBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MsgBookController {
	@Autowired
	private MsgBookService msgBookService;
	
	@RequestMapping(value="/msgbook.html", method=RequestMethod.GET)
	public String showMsgBook(ModelMap model){
		model.addAttribute("messages", msgBookService.getMsgs());
		return "msgbook";
	}
	
	@RequestMapping(value="/msgbook.do", method=RequestMethod.POST)
	public String dataMsgBook(@RequestParam("msgtitle") String msgtitle ,HttpServletRequest request, HttpServletResponse response, ModelMap model){
		String msgContent = request.getParameter("msg");
		Message msg = new Message();
		msg.setId(UUID.randomUUID().toString().replace("-", ""));
		msg.setTitle(msgtitle);
		msg.setContent(msgContent);

		if(msgBookService.saveMsg(msg) > 0){
			return "redirect:/msgbook.html";
		}
		return "redirect:/msgbook.html";
	}
	
}
