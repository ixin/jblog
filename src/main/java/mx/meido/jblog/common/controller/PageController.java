package mx.meido.jblog.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping(value="/admin/frameMain.html")
	public String showFrameMain(){
		return "frameMain";
	}
	@RequestMapping(value="/profile.html")
	public String showProfile(){
		return "profile";
	}
	@RequestMapping(value="/login.html")
	public String showLogin(){
		return "login";
	}

}
