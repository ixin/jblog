package mx.meido.jblog.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping(value="/frameMain.html")
	public String showFrameMain(){
		return "frameMain";
	}

}
