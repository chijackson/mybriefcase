package org.filecab.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class DvdProfileForm implements Serializable {

	private static final long serialVersionUID = 1L;
	private String selectedProfileId = new String();
	private List<DvdProfile> profiles = new ArrayList<DvdProfile>();

	public DvdProfileForm() {
	}

	public String getSelectedProfileId() {
		return selectedProfileId;
	}

	public void setSelectedProfileId(String selectedProfileId) {
		this.selectedProfileId = selectedProfileId;
	}

	public List<DvdProfile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<DvdProfile> profiles) {
		this.profiles = profiles;
	}
	
}
