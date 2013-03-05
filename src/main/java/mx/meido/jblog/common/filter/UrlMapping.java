package mx.meido.jblog.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

/**
 * Servlet Filter implementation class UrlMapping
 */
public class UrlMapping implements Filter {

    /**
     * Default constructor. 
     */
    public UrlMapping() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = ((HttpServletRequest)request);
		HttpServletResponse res = ((HttpServletResponse)response);
		String cxtPath = req.getContextPath();
		System.out.println(req.getServletPath() + " ---- " + req.getParameterNames().hasMoreElements());
		String url = req.getServletPath();
		String[] url_params = url.split("/");
		//分析url
		if(!req.getParameterNames().hasMoreElements()){
			if(url_params[1].equals("post") && url_params.length == 3){
				req.getRequestDispatcher("/p.do?id="+url_params[2]).forward(req, res);
			}else if(url_params[1].equals("tag") && url_params.length == 3){
				req.getRequestDispatcher("/t.do?id="+url_params[2]).forward(req, res);
			}else if(url_params[1].equals("page") && url_params.length == 3){
				req.getRequestDispatcher("/page.do?id="+url_params[2]).forward(req, res);
			} else {
				chain.doFilter(request, response);
			}
		}else {
			if(url_params[1].equals("admin") || url_params[1].equals("login.html")){
				chain.doFilter(request, response);
			} else {
				res.sendRedirect(cxtPath+"/404.html");
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
