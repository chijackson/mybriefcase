/**
 * 
 */
package org.filecab.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.filecab.bean.Login;
import org.filecab.bean.WebsiteProfile;
import org.filecab.bean.WebsiteProfileForm;
import org.filecab.business.manager.WebsiteProfileManager;
import org.filecab.exception.SystemPersistenceException;
import org.filecab.util.ApplicationBeanFactory;
import org.filecab.util.JSFUtils;
import org.filecab.util.PrimeFacesUtils;
import org.primefaces.event.RowEditEvent;

/**
 * @author chiwu
 *
 */
@ManagedBean
@RequestScoped
public class WebsiteProfileController extends Controller {
	
	private WebsiteProfileManager manager;
	
	public WebsiteProfileController() {
		setManager((WebsiteProfileManager) ApplicationBeanFactory.getBean(WebsiteProfileManager.class));
	}

	public void ajaxOnEditProfile(RowEditEvent event) {
		WebsiteProfile profile = (WebsiteProfile) event.getObject();
		
		if (null != profile) {
			try {
				getManager().modifyProfile(profile);
				JSFUtils.addMessage(
					FacesMessage.SEVERITY_INFO, 
					null, 
					"Profile Changed!", 
					"Website Profile " + ((WebsiteProfile) event.getObject()).getName() + " Updated!");
			} catch (SystemPersistenceException spe) {
				processError(spe, true);
			}
		}
	}
	
	public void ajaxDeleteProfile() {
		WebsiteProfileForm formBean = (WebsiteProfileForm) JSFUtils.getSessionBean("websiteProfileForm");
		WebsiteProfile selectedProfile = null;
		
		for (WebsiteProfile websiteProfile : formBean.getWebsiteProfiles()) {
			if (formBean.getSelectedWebsiteProfileId().equals(websiteProfile.getId())) {
				selectedProfile = websiteProfile;
				break;
			}
		}
		
		if (null != selectedProfile) {
			try {
				getManager().removeProfile(selectedProfile.getId());
				formBean.getWebsiteProfiles().remove(selectedProfile);
				JSFUtils.addMessage(
					FacesMessage.SEVERITY_INFO,
					null, 
					"Profile Changed!",
					"Website Profile " + selectedProfile.getName() + " Deleted");
			} catch (SystemPersistenceException spe) {
				processError(spe, true);
			}
		}
	}
	
	public void ajaxSaveNewProfile() {
		WebsiteProfileForm formBean = (WebsiteProfileForm) JSFUtils.getSessionBean("websiteProfileForm");
		WebsiteProfile profile = (WebsiteProfile) JSFUtils.getRequestBean("websiteProfile");
		Login loginBean = (Login) JSFUtils.getSessionBean("login");
		
		if (null != profile) {
			profile.setProfileId(loginBean.getUser().getUserId());
			try {
				getManager().storeProfile(profile);
				formBean.getWebsiteProfiles().add(0, profile);
				JSFUtils.addMessage(
					FacesMessage.SEVERITY_INFO, 
					"msgs-new-profile", 
					"Website Profile " + profile.getName() + " Saved", 
					null);
				PrimeFacesUtils.executeScript("resetNewWebsiteProfileForm()");
			} catch (SystemPersistenceException spe) {
				processError(spe, true);
			}
		}
	}
	
	public String actionNavNewProfile() {
		return "/pages/websiteprofile/website-profile-new";
	}
	
	public String actionNavProfileList() {
		return "/pages/websiteprofile/website-profile-list";
	}
	
	public String actionNavHome() {
		return "/pages/home";
	}
	
	public String actionLoadProfiles() {
		WebsiteProfileForm formBean = (WebsiteProfileForm) JSFUtils.getSessionBean("websiteProfileForm");
		Login loginBean = (Login) JSFUtils.getSessionBean("login");
		
		if (null == formBean) {
			formBean = new WebsiteProfileForm();
			JSFUtils.putBeanInSession("websiteProfileForm", formBean);
		}
		
		try {
			formBean.setWebsiteProfiles(getManager().fetchAllProfiles(loginBean.getUser().getUserId()));
		} catch (SystemPersistenceException spe) {
			processError(spe, true);
		}
		
		return "/pages/websiteprofile/website-profile-list";
	}

	public WebsiteProfileManager getManager() {
		return manager;
	}

	public void setManager(WebsiteProfileManager manager) {
		this.manager = manager;
	}
	
}
