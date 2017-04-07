/**
 * 
 */
package org.filecab.bean;

import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author chiwu
 *
 */
@ManagedBean
@RequestScoped
public class DvdProfile extends Profile {

	private static final long serialVersionUID = 1L;
	private String title = new String();
	private String serial = new String();
	
	public DvdProfile() {
		setId(UUID.randomUUID().toString());
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}
	
}
