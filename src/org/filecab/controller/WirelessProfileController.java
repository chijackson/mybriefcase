/**
 * 
 */
package org.filecab.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.filecab.bean.Login;
import org.filecab.bean.WirelessProfile;
import org.filecab.bean.WirelessProfileForm;
import org.filecab.business.manager.WirelessProfileManager;
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
public class WirelessProfileController extends Controller {

	private WirelessProfileManager manager;
	
	public WirelessProfileController() {
		setManager((WirelessProfileManager) ApplicationBeanFactory.getBean(WirelessProfileManager.class));
	}
	
	public void ajaxOnEditProfile(RowEditEvent event) {
		WirelessProfile profile = (WirelessProfile) event.getObject();
		
		if (null != profile) {
			try {
				getManager().modifyProfile(profile);
				JSFUtils.addMessage(
					FacesMessage.SEVERITY_INFO, 
					null, 
					"Profile Changed!", 
					"Wireless Profile " + ((WirelessProfile) event.getObject()).getDeviceName() + " Updated!");
			} catch (SystemPersistenceException spe) {
				processError(spe, true);
			}
		}
	}
	
	public void ajaxDeleteProfile() {
		WirelessProfileForm formBean = (WirelessProfileForm) JSFUtils.getSessionBean("wirelessProfileForm");
		WirelessProfile selectedProfile = null;
		
		for (WirelessProfile profile : formBean.getWirelessProfiles()) {
			if (formBean.getSelectedWirelessProfileId().equals(profile.getId())) {
				selectedProfile = profile;
				break;
			}
		}
		
		if (null != selectedProfile) {
			try {
				getManager().removeProfile(selectedProfile.getId());
				formBean.getWirelessProfiles().remove(selectedProfile);
				JSFUtils.addMessage(
					FacesMessage.SEVERITY_INFO,
					null, 
					"Profile Changed!",
					"Website Profile " + selectedProfile.getDeviceName() + " Deleted");
			} catch (SystemPersistenceException spe) {
				processError(spe, true);
			}
		}
	}
	
	public void ajaxSaveNewProfile() {
		WirelessProfileForm formBean = (WirelessProfileForm) JSFUtils.getSessionBean("wirelessProfileForm");
		WirelessProfile profile = (WirelessProfile) JSFUtils.getRequestBean("wirelessProfile");
		Login loginBean = (Login) JSFUtils.getSessionBean("login");
		
		if (null != profile) {
			profile.setProfileId(loginBean.getUser().getUserId());
			try {
				getManager().storeProfile(profile);
				formBean.getWirelessProfiles().add(0, profile);
				JSFUtils.addMessage(
					FacesMessage.SEVERITY_INFO, 
					"msgs-new-profile", 
					"Wireless Profile " + profile.getDeviceName() + " Saved", 
					null);
				PrimeFacesUtils.executeScript("resetNewWirelessProfileForm()");
			} catch (SystemPersistenceException spe) {
				processError(spe, true);
			}
		}
	}
	
	public String actionNavNewProfile() {
		return "/pages/wirelessprofile/wireless-profile-new";
	}
	
	public String actionNavProfileList() {
		return "/pages/wirelessprofile/wireless-profile-list";
	}
	
	public String actionNavHome() {
		return "/pages/home";
	}
	
	public String actionLoadProfiles() {
		WirelessProfileForm formBean = (WirelessProfileForm) JSFUtils.getSessionBean("wirelessProfileForm");
		Login loginBean = (Login) JSFUtils.getSessionBean("login");
		
		if (null == formBean) {
			formBean = new WirelessProfileForm();
			JSFUtils.putBeanInSession("wirelessProfileForm", formBean);
		}
		
		try {
			formBean.setWirelessProfiles(getManager().fetchAllProfiles(loginBean.getUser().getUserId()));
		} catch (SystemPersistenceException spe) {
			processError(spe, true);
		}
		
		return "/pages/wirelessprofile/wireless-profile-list";
	}

	public WirelessProfileManager getManager() {
		return manager;
	}

	public void setManager(WirelessProfileManager manager) {
		this.manager = manager;
	}
	
}
