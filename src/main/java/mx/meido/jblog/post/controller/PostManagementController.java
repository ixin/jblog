package mx.meido.jblog.post.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.meido.jblog.post.domain.Post;
import mx.meido.jblog.post.domain.PostValue;
import mx.meido.jblog.post.service.PostService;
import mx.meido.jblog.user.model.UserInfo;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class PostManagementController {
	@Autowired
	private PostService postService;
	
	@RequestMapping(value="/admin/postManagementList.html", method=RequestMethod.GET)
	public String showPostManagementList(){
		return "postManagementList";
	}
	
	@RequestMapping(value="/admin/postManagementList.do", method=RequestMethod.POST)
	public String getPostManagementList(HttpServletResponse response, HttpServletRequest request) throws IOException{
		JSONObject jsonObj = new JSONObject();
		doSearch(jsonObj, request);
		PrintWriter pw = response.getWriter();
		pw.print(jsonObj.toString());
		pw.close();
		return null;
	}
	
	@RequestMapping(value="/admin/postManagementNewPost.html", method=RequestMethod.GET)
	public String showPostManagementNewPost(){
		return "postManagementNewPost";
	}
	
	public void doSearch(JSONObject jsonObj, HttpServletRequest request){
		String pageNum = request.getParameter("page");
		String rowsNum = request.getParameter("rows");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		int currPage = Integer.valueOf(pageNum);
		int resultCountPerPage = Integer.valueOf(rowsNum);
		System.out.println(currPage + " - " + resultCountPerPage);
		UserInfo userinfo = new UserInfo();
		userinfo.setUsername(username);
		userinfo.setEmail(email);
		List<Post> posts = postService.getPostFromAndLimitWithTimeDesc((currPage - 1) * resultCountPerPage, resultCountPerPage);
		Integer total = postService.getPostCount();
		jsonObj.put("total", total);
		JSONObject tjsonObj = null;
		for(Post p : posts){
			tjsonObj = new JSONObject();
			tjsonObj.put("id", p.getPostId());
			PostValue pv = p.getPostValue();
			tjsonObj.put("title", pv.getTitle());
			tjsonObj.put("summary", pv.getSummary());
			tjsonObj.put("nickname", p.getUser().getNickname());
			tjsonObj.put("posttime", pv.getPostTime().getTime());
			jsonObj.accumulate("rows", tjsonObj);
		}
		
	}
}
