package cn.ciwest.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class IPCheckFilter
 */
@WebFilter(
		urlPatterns = { "*.jsp" }, 
		initParams = { 
				@WebInitParam(name = "IPS", value = "0:0:0:0:0:0:0:1;127.0.0.1;192.168.31.221;192.168.31.127")
		})
public class IPCheckFilter implements Filter {

	String ips=null;
    /**
     * Default constructor. 
     */
    public IPCheckFilter() {
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
		
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		
		String uri=req.getRequestURI();
		if(uri.equals("/JavaeeHomework/error/error.jsp")){
			chain.doFilter(request, response);
		}
		else{
			String ip=req.getRemoteAddr();
			System.out.println(ip);
			if(!ips.contains(ip)){
				System.out.println("IP被禁止访问");
				res.sendRedirect("/JavaeeHomework/error/error.jsp");
			}
			else{
				// pass the request along the filter chain
				chain.doFilter(request, response);
			}
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		ips=config.getInitParameter("IPS");
				
	}

}
