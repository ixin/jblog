package mx.meido.jblog.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.meido.jblog.common.tools.JsonDateValueProcessor;
import mx.meido.jblog.user.model.UserInfo;
import mx.meido.jblog.user.service.UserInfoService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserManageController {
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping(value="/admin/userManagementList.html", method=RequestMethod.GET)
	public String showUserManagementList(){
		return "userManagementList";
	}
	
	@RequestMapping(value="/admin/userManagementList.do", method=RequestMethod.POST)
	public String getUserManagementListJson(HttpServletResponse response, HttpServletRequest request) throws IOException{
		JSONObject jsonObj = new JSONObject();
		doSearch(jsonObj, request);
		PrintWriter pw = response.getWriter();
		pw.print(jsonObj.toString());
		pw.close();
		return null;
	}
	
	public void doSearch(JSONObject jsonObj, HttpServletRequest request){
		String pageNum = request.getParameter("page");
		String rowsNum = request.getParameter("rows");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		int currPage = Integer.valueOf(pageNum);
		int resultCountPerPage = Integer.valueOf(rowsNum);
		UserInfo userinfo = new UserInfo();
		userinfo.setUsername(username);
		userinfo.setEmail(email);
		List<Map<String, Object>> total = userInfoService.getUserInfos(userinfo,  (currPage - 1) * resultCountPerPage  , resultCountPerPage);
		Integer rows = userInfoService.getUserInfosCount(userinfo);
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(java.util.Date.class, new JsonDateValueProcessor());
		jsonObj.put("total", JSONArray.fromObject(total, config));
		jsonObj.put("rows", rows);
	}
}
