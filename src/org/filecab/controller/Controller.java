package org.filecab.controller;

import java.io.IOException;

import org.filecab.exception.SystemPersistenceException;
import org.filecab.util.JSFUtils;

public abstract class Controller {

	protected void processError(SystemPersistenceException spe, boolean loggedIn) {
		System.out.println("ERROR: " + spe.getMessage());
		try {
			if (loggedIn) {
				JSFUtils.redirect("/pages/error/system-error.faces");
			} else {
				JSFUtils.redirect("/pages/error/system-error-external.faces");
			}
		} catch (IOException e1) {
			System.out.println("Error occurred trying to redirect to the system error page.");
		}
	}
}
