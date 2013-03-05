package mx.meido.jblog.terms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.meido.jblog.terms.model.Terms;
import mx.meido.jblog.terms.service.TermsService;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TermsManagementController {
	@Autowired
	private TermsService termsService;
	/**
	 * 分类目录、标签
	 * @return
	 */
	@RequestMapping(value="/admin/termsManagement.html", method=RequestMethod.GET)
	public String showTermsManagement(@RequestParam("type") String type, ModelMap modelMap){
		modelMap.addAttribute("type", type);
		return "termsManagement";
	}
	
	@RequestMapping(value="/admin/termsManagement.do", method=RequestMethod.POST)
	public String getTermsManagementJson(@RequestParam("type") String type,HttpServletResponse response, HttpServletRequest request) throws IOException{
		JSONObject jsonObj = new JSONObject();
		doSearch(jsonObj, request, type);
		PrintWriter pw = response.getWriter();
		pw.print(jsonObj.toString());
		pw.close();
		return null;
	}
	
	public void doSearch(JSONObject jsonObj, HttpServletRequest request, String type){
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		if(StringUtils.isNotBlank(type) && StringUtils.isNotBlank(page) && StringUtils.isNotBlank(rows)){
			List<Map<String, Object>> termsList = null;
			int total = 0;
			if(type.equals("category")){
				termsList = termsService.getCategoryTerms((Integer.parseInt(page)-1)*Integer.parseInt(rows), Integer.parseInt(rows));
				total = termsService.getCategoryTermsCount();
			} else {
				termsList = termsService.getTagTerms((Integer.parseInt(page)-1)*Integer.parseInt(rows), Integer.parseInt(rows));
				total = termsService.getTagTermsCount();
			}
			if(termsList != null && termsList.size() > 0){
				jsonObj.put("rows", termsList);
			}else {
				jsonObj.put("rows", "[]");
			}
			jsonObj.put("total", total);
		}
	}
	
	@RequestMapping(value="/admin/termsManagementAdd.do", method=RequestMethod.POST)
	public String getTermsManagementAdd(@RequestParam("type") String type,HttpServletResponse response, HttpServletRequest request) throws IOException{
		PrintWriter pw = response.getWriter();
		String termsName = request.getParameter("termsname");
		if(StringUtils.isNotBlank(type) && StringUtils.isNotBlank(termsName)){
			
			String termsSummary = request.getParameter("termssummary");
			Terms terms = new Terms(null, termsName, termsSummary, null, null);
			if(type.equals("category")){
				if(termsService.saveCategoryTerms(terms) == 1){
					pw.print("success");
				}else {
					pw.print("error");
				}
			}else {
				if(termsService.saveTagTerms(terms) == 1){
					pw.print("success");
				}else {
					pw.print("error");
				}
			}
		}else {
			pw.print("error");
		}
		pw.close();
		return null;
	}

}
