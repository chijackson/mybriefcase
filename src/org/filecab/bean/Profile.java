package org.filecab.bean;

import java.io.Serializable;

public abstract class Profile  implements Serializable {

	private static final long serialVersionUID = 1L;
	private String profileId = new String();
	private String id = new String();

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
