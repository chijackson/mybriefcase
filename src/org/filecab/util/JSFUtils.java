package org.filecab.util;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


public final class JSFUtils {

	private JSFUtils() {
	}
	
	public static void addMessage(FacesMessage.Severity severity, String componentName, 
			String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(
			componentName, new FacesMessage(severity, summary, detail));
	}
	
	public static Object getSessionBean(String beanName) {
		return FacesContext.getCurrentInstance().getExternalContext().
			getSessionMap().get(beanName);
	}
	
	public static void putBeanInSession(String beanName, Object bean) {
		FacesContext.getCurrentInstance().getExternalContext().
			getSessionMap().put(beanName, bean);
	}
	
	public static Object getRequestBean(String beanName) {
		return FacesContext.getCurrentInstance().getExternalContext().
			getRequestMap().get(beanName);
	}
	
	public static void removeSessionBean(String beanName) {
		FacesContext.getCurrentInstance().getExternalContext().
			getSessionMap().remove(beanName);
	}
	
	public static void redirect(String redirectPath) throws IOException {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + redirectPath);
	}
	
	public static void logout() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
	}
	
}
