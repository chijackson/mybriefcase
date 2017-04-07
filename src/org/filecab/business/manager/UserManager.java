/**
 * 
 */
package org.filecab.business.manager;

import org.filecab.bean.User;
import org.filecab.exception.SystemPersistenceException;
import org.filecab.persistence.dao.UserDao;
import org.filecab.util.EncryptionUtils;

/**
 * @author tso7924
 *
 */
public class UserManager {
	
	private UserDao dao;
	
	public UserManager() {
	}

	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	
	public User fetchUser(String userId, String password) throws SystemPersistenceException {
		String encryptedPassw = EncryptionUtils.encrypt(password);
		User user = dao.retrieveUser(userId, encryptedPassw);
		if (null != user) {
			user.setPassword(EncryptionUtils.decrypt(user.getEncryptedPassword()));
		}
		return user;
	}

	public void registerUser(User user) throws SystemPersistenceException {
		String encryptedPassw = EncryptionUtils.encrypt(user.getPassword());
		user.setEncryptedPassword(encryptedPassw);
		dao.saveUser(user);
	}

}
