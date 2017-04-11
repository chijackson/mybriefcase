package org.filecab.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.filecab.bean.Login;
import org.filecab.bean.RegistrationForm;
import org.filecab.business.manager.UserManager;
import org.filecab.exception.SystemPersistenceException;
import org.filecab.util.ApplicationBeanFactory;
import org.filecab.util.JSFUtils;
import org.primefaces.event.FlowEvent;

@ManagedBean
@RequestScoped
public class RegistrationController extends Controller {

	public static final String TAB_USER = "tabUser";
	public static final String TAB_CONFIRM = "tabConfirm";
	
	public String onFlowProcess(FlowEvent event) {
		String forwardStep = event.getNewStep();
		RegistrationForm registrationBean = (RegistrationForm) JSFUtils.getSessionBean("registrationForm");
		
		if (TAB_USER.equals(forwardStep)) {
			registrationBean.setRenderBackButton(false);
			registrationBean.setRenderNextButton(true);
			registrationBean.setRenderSubmitButton(false);
		} else if(TAB_CONFIRM.equals(forwardStep)) {
			registrationBean.setRenderBackButton(true);
			registrationBean.setRenderNextButton(false);
			registrationBean.setRenderSubmitButton(true);
		}
		
		return forwardStep;
	}
	
	public String actionRegisterUser() {
		UserManager manager = (UserManager) ApplicationBeanFactory.getBean(UserManager.class);
		RegistrationForm registrationBean = (RegistrationForm) JSFUtils.getSessionBean("registrationForm");
		
		try {
			manager.registerUser(registrationBean.getUser());
			Login login = new Login();
			login.setUser(registrationBean.getUser());
			JSFUtils.putBeanInSession("login", login);
			JSFUtils.removeSessionBean("registrationForm");
		} catch (SystemPersistenceException spe) {
			JSFUtils.removeSessionBean("registrationForm");
			processError(spe, false);
		}
		
		return "/registration/confirmation";
	}
	
	public String actionNavLogin() {
		JSFUtils.removeSessionBean("registrationForm");
		return "/login";
	}
	
}
