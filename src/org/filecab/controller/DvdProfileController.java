/**
 * 
 */
package org.filecab.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.filecab.bean.DvdProfile;
import org.filecab.bean.DvdProfileForm;
import org.filecab.bean.Login;
import org.filecab.business.manager.DvdProfileManager;
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
public class DvdProfileController extends Controller {

	private DvdProfileManager manager;
	
	public DvdProfileController() {
		setManager((DvdProfileManager) ApplicationBeanFactory.getBean(DvdProfileManager.class));
	}
	
	public String actionNavHome() {
		return "/pages/home";
	}
	
	public String actionNavNewProfile() {
		return "/pages/dvdprofile/dvd-profile-new";
	}
	
	public String actionLoadProfiles() {
		DvdProfileForm formBean = (DvdProfileForm) JSFUtils.getSessionBean("dvdProfileForm");
		Login loginBean = (Login) JSFUtils.getSessionBean("login");
		
		if (null == formBean) {
			formBean = new DvdProfileForm();
			JSFUtils.putBeanInSession("dvdProfileForm", formBean);
		}
		
		try {
			formBean.setProfiles(getManager().fetchAllProfiles(loginBean.getUser().getUserId()));
		} catch (SystemPersistenceException spe) {
			processError(spe, true);
		}
		
		return "/pages/dvdprofile/dvd-profile-list";
	}
	
	public String actionNavProfileList() {
		return "/pages/dvdprofile/dvd-profile-list";
	}
	
	public void ajaxOnEditProfile(RowEditEvent event) {
		DvdProfile profile = (DvdProfile) event.getObject();
		
		if (null != profile) {
			try {
				getManager().modifyProfile(profile);
				JSFUtils.addMessage(
					FacesMessage.SEVERITY_INFO, 
					null, 
					"Profile Changed!", 
					"DVD Profile " + ((DvdProfile) event.getObject()).getTitle() + " Updated!");
			} catch (SystemPersistenceException spe) {
				processError(spe, true);
			}
		}
	}
	
	public void ajaxDeleteProfile() {
		DvdProfileForm formBean = (DvdProfileForm) JSFUtils.getSessionBean("dvdProfileForm");
		DvdProfile selectedProfile = null;
		
		for (DvdProfile profile : formBean.getProfiles()) {
			if (formBean.getSelectedProfileId().equals(profile.getId())) {
				selectedProfile = profile;
				break;
			}
		}
		
		if (null != selectedProfile) {
			try {
				getManager().removeProfile(selectedProfile.getId());
				formBean.getProfiles().remove(selectedProfile);
				JSFUtils.addMessage(
					FacesMessage.SEVERITY_INFO,
					null, 
					"Profile Changed!",
					"DVD Profile " + selectedProfile.getTitle() + " Deleted");
			} catch (SystemPersistenceException spe) {
				processError(spe, true);
			}
		}
	}
	
	public void ajaxSaveNewProfile() {
		DvdProfileForm formBean = (DvdProfileForm) JSFUtils.getSessionBean("dvdProfileForm");
		DvdProfile profile = (DvdProfile) JSFUtils.getRequestBean("dvdProfile");
		Login loginBean = (Login) JSFUtils.getSessionBean("login");
		
		if (null != profile) {
			profile.setProfileId(loginBean.getUser().getUserId());
			try {
				getManager().storeProfile(profile);
				formBean.getProfiles().add(0, profile);
				JSFUtils.addMessage(
					FacesMessage.SEVERITY_INFO, 
					"msgs-new-profile", 
					"DVD Profile " + profile.getTitle() + " Saved", 
					null);
				PrimeFacesUtils.executeScript("resetNewDvdProfileForm()");
			} catch (SystemPersistenceException spe) {
				processError(spe, true);
			}
		}
		
	}

	public DvdProfileManager getManager() {
		return manager;
	}

	public void setManager(DvdProfileManager manager) {
		this.manager = manager;
	}

}
