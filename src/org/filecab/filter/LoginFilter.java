package org.filecab.filter;

import java.io.IOException;

import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.filecab.bean.Login;

@WebFilter("/pages/*")
public class LoginFilter implements Filter {

	private static final String AJAX_REDIRECT_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
	        + "<partial-response><redirect url=\"%s\"></redirect></partial-response>";

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("DO FILTER");
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginURL = request.getContextPath() + "/login.faces";
        String registerURL = request.getContextPath() + "/registration/register.faces";

        boolean loggedIn = (session != null) && (((Login) session.getAttribute("login")) != null)
        		&& (((Login) session.getAttribute("login")).isLoggedIn());
        boolean loginRequest = request.getRequestURI().equals(loginURL);
        boolean registerRequest = request.getRequestURI().equals(registerURL);
        boolean resourceRequest = request.getRequestURI().startsWith(request.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER + "/");
        boolean ajaxRequest = "partial/ajax".equals(request.getHeader("Faces-Request"));

        if (loggedIn || loginRequest || resourceRequest || registerRequest) {
            if (!resourceRequest) { // Prevent browser from caching restricted resources. See also http://stackoverflow.com/q/4194207/157882
                response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
                response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
                response.setDateHeader("Expires", 0); // Proxies.
            }

            chain.doFilter(request, response); // So, just continue request.
        }
        else if (ajaxRequest) {
            response.setContentType("text/xml");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().printf(AJAX_REDIRECT_XML, loginURL); // So, return special XML response instructing JSF ajax to send a redirect.
        }
        else {
            response.sendRedirect(loginURL); // So, just perform standard synchronous redirect.
        }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		/** If you have any <init-param> in web.xml, then you could get them
        	here by config.getInitParameter("name") and assign it as field. */
	}
	
	@Override
	public void destroy() {
		/** If you have assigned any expensive resources as field of
    		this Filter class, then you could clean/close them here. */
	}

}
