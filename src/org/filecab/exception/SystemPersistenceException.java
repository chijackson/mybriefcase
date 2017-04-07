/**
 * 
 */
package org.filecab.exception;

/**
 * @author tso7924
 *
 */
public class SystemPersistenceException extends Exception {

	private static final long serialVersionUID = -7885460242390611781L;

	public SystemPersistenceException(Exception exception) {
		super(exception);
	}
	
}
