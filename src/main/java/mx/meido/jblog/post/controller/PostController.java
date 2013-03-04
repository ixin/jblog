package mx.meido.jblog.post.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.meido.jblog.post.domain.Post;
import mx.meido.jblog.post.domain.PostStatus.PostStage;
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
	
	@RequestMapping(value="/p.do")
	public String getPost(@RequestParam("id") long id, ModelMap modelMap){
		Map<String, Object> post = postService.getPost(id);
		modelMap.put("post", post);
		return "post";
	}
	
	@RequestMapping(value="/profile.html")
	public String showProfile(ModelMap modelMap){
		List<Post> list = postService.getPostFromAndLimitWithTimeDesc(0, 10, PostStage.PUBLISH.getStage());
		List<Map<String, Object>> posts = new ArrayList<Map<String, Object>>();
		for(Post p : list){
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("title", p.getPostValue().getTitle());
			map.put("id", p.getPostId());
			map.put("own", p.getUser().getNickname());
			map.put("time", p.getPostValue().getPostTime());
			map.put("content", p.getPostValue().getContent());
			posts.add(map);
		}
		modelMap.addAttribute("posts", posts);
		return "profile";
	}
}
