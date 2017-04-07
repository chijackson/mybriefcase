package org.filecab.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class WebsiteProfileForm implements Serializable {

	private static final long serialVersionUID = 1L;
	private String selectedWebsiteProfileId = new String();
	private List<WebsiteProfile> websiteProfiles = new ArrayList<WebsiteProfile>();
	private List<WebsiteProfile> filteredWebsiteProfiles = null;
	
	public WebsiteProfileForm() {
	}
	
	public List<WebsiteProfile> getWebsiteProfiles() {
		return websiteProfiles;
	}
	
	public void setWebsiteProfiles(List<WebsiteProfile> websiteProfiles) {
		this.websiteProfiles = websiteProfiles;
	}
	
	public List<WebsiteProfile> getFilteredWebsiteProfiles() {
		return filteredWebsiteProfiles;
	}
	
	public void setFilteredWebsiteProfiles(List<WebsiteProfile> filteredWebsiteProfiles) {
		this.filteredWebsiteProfiles = filteredWebsiteProfiles;
	}

	public String getSelectedWebsiteProfileId() {
		return selectedWebsiteProfileId;
	}

	public void setSelectedWebsiteProfileId(String selectedWebsiteProfileId) {
		this.selectedWebsiteProfileId = selectedWebsiteProfileId;
	}

}
