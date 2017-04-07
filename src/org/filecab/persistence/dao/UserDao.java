/**
 * 
 */
package org.filecab.persistence.dao;

import org.filecab.bean.User;
import org.filecab.exception.SystemPersistenceException;

/**
 * @author tso7924
 *
 */
public interface UserDao {

	User retrieveUser(String userId, String password) throws SystemPersistenceException;

	void saveUser(User user) throws SystemPersistenceException;
}
