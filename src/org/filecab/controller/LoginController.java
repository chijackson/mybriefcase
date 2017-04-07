/**
 * 
 */
package org.filecab.controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.filecab.bean.Login;
import org.filecab.bean.User;
import org.filecab.business.manager.UserManager;
import org.filecab.exception.SystemPersistenceException;
import org.filecab.util.ApplicationBeanFactory;
import org.filecab.util.JSFUtils;

/**
 * @author tso7924
 *
 */
@ManagedBean
@RequestScoped
public class LoginController extends Controller{
	
	public LoginController() {
	}

	public String actionLogin() {
		String returnVal = new String();
		User user = null;
		Login loginBean = (Login) JSFUtils.getSessionBean("login");
		
		UserManager manager = (UserManager) ApplicationBeanFactory.getBean(UserManager.class);
		try {
			user = manager.fetchUser(loginBean.getUser().getUserId(), loginBean.getUser().getPassword());
		} catch (SystemPersistenceException spe) {
			processError(spe, false);
		}
		
		if (null == user) {
			JSFUtils.addMessage(
				FacesMessage.SEVERITY_ERROR, 
				null, 
				"Login failed.",
				null);
			returnVal = "";
		} else {
			loginBean.setUser(user);
			loginBean.setLoggedIn(true);
			returnVal = "/pages/home";
		}

		return returnVal;
	}
	
	public String actionLogout() {
		JSFUtils.removeSessionBean("dvdProfile");
		JSFUtils.removeSessionBean("login");
		JSFUtils.removeSessionBean("userProfile");
		JSFUtils.removeSessionBean("websiteProfile");
		JSFUtils.removeSessionBean("wirelessProfile");
		
		return "/login";
	}

	public String actionNavRegistration() {
		JSFUtils.removeSessionBean("login");
		return "/pages/registration/register";
	}
	
	public void checkUserLoggedIn() {
		System.out.println("Inside check login");
		Login loginBean = (Login) JSFUtils.getSessionBean("login");
		if (null != loginBean && loginBean.isLoggedIn()) {
			try {
				JSFUtils.redirect("/pages/home.faces");
			} catch (IOException e) {
				System.out.println("Error occurred trying to redirect to the home page.");
			}
		}
	}
	
}
