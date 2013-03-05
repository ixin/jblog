package mx.meido.jblog.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class PageController {
	@RequestMapping(value="/admin/frameMain.html")
	public String showFrameMain(HttpServletRequest request){
		HttpSession hs = request.getSession();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		hs.setAttribute("u", userDetails.getUsername());
		return "frameMain";
	}

	@RequestMapping(value="/login.html")
	public String showLogin(){
		return "login";
	}
	
	@RequestMapping(value="/404.html")
	public String show404(){
		return "404";
	}

}
