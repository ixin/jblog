package mx.meido.jblog.post.controller;

import java.util.Map;

import mx.meido.jblog.post.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {
	@Autowired
	private PostService postService;
	
	@RequestMapping(value="/p")
	public String getPost(@RequestParam("id") long id, ModelMap modelMap){
		Map<String, Object> post = postService.getPost(id);
		modelMap.put("post", post);
		return "post";
	}
}
