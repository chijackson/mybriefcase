/**
 * 
 */
package org.filecab.bean;

import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@ManagedBean
@RequestScoped
public class WirelessProfile extends Profile {

	private static final long serialVersionUID = 1L;
	private String ipAddress = new String();
	private String deviceName = new String();
	private boolean active = true;
	private int gigahertz = 0;
	
	public WirelessProfile() {
		setId(UUID.randomUUID().toString());
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getGigahertz() {
		return gigahertz;
	}

	public void setGigahertz(int gigahertz) {
		this.gigahertz = gigahertz;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
