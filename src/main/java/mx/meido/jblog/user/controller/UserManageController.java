package mx.meido.jblog.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserManageController {
	@RequestMapping(value="/admin/userManagementList.html", method=RequestMethod.GET)
	public String showUserManagementList(){
		return "userManagementList";
	}
	
	@RequestMapping(value="/admin/userManagementList.do", method=RequestMethod.POST)
	public String getUserManagementListJson(){
		
		return null;
	}
}
