package org.filecab.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.filecab.controller.helper.DropDownUtil;

@ManagedBean
@SessionScoped
public class WirelessProfileForm implements Serializable {

	private static final long serialVersionUID = 1L;
	private String selectedWirelessProfileId = new String();
	private List<WirelessProfile> wirelessProfiles = new ArrayList<WirelessProfile>();
	private List<SelectItem> gigahertzSelectItems = null;

	public WirelessProfileForm() {
		if (null == getGigahertzSelectItems()) {
			setGigahertzSelectItems(DropDownUtil.getGigahertzValues());
		}
	}

	public String getSelectedWirelessProfileId() {
		return selectedWirelessProfileId;
	}

	public void setSelectedWirelessProfileId(String selectedWirelessProfileId) {
		this.selectedWirelessProfileId = selectedWirelessProfileId;
	}

	public List<WirelessProfile> getWirelessProfiles() {
		return wirelessProfiles;
	}

	public void setWirelessProfiles(List<WirelessProfile> wirelessProfiles) {
		this.wirelessProfiles = wirelessProfiles;
	}

	public List<SelectItem> getGigahertzSelectItems() {
		return gigahertzSelectItems;
	}

	public void setGigahertzSelectItems(List<SelectItem> gigahertzSelectItems) {
		this.gigahertzSelectItems = gigahertzSelectItems;
	}
	
}
