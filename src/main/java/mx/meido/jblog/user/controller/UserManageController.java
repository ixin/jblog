package mx.meido.jblog.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

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
	public String getUserManagementListJson(HttpServletResponse response, HttpServletRequest request) throws IOException{
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("total", "0");
		jsonObj.put("rows", "[]");
		PrintWriter pw = response.getWriter();
		pw.print(jsonObj.toString());
		pw.close();
		return null;
	}
	
	public void doSearch(JSONObject jsonObj, HttpServletRequest request){
		
	}
}
