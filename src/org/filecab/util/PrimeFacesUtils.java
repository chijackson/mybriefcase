package org.filecab.util;

import org.primefaces.context.RequestContext;

public final class PrimeFacesUtils {

	private PrimeFacesUtils() {
	}
	
	public static void executeScript(String scriptName) {
		RequestContext.getCurrentInstance().execute(scriptName);
	}
	
}
