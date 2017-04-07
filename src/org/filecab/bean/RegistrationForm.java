package org.filecab.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class RegistrationForm implements Serializable {

	private static final long serialVersionUID = 1L;
	private User user = new User();
	private boolean renderBackButton = false;
	private boolean renderNextButton = true;
	private boolean renderSubmitButton = false;
	
	public RegistrationForm() {
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public boolean isRenderNextButton() {
		return renderNextButton;
	}

	public void setRenderNextButton(boolean renderNextButton) {
		this.renderNextButton = renderNextButton;
	}

	public boolean isRenderBackButton() {
		return renderBackButton;
	}

	public void setRenderBackButton(boolean renderBackButton) {
		this.renderBackButton = renderBackButton;
	}

	public boolean isRenderSubmitButton() {
		return renderSubmitButton;
	}

	public void setRenderSubmitButton(boolean renderSubmitButton) {
		this.renderSubmitButton = renderSubmitButton;
	}

}
