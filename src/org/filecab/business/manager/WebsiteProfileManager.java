/**
 * 
 */
package org.filecab.business.manager;

import java.util.List;

import org.filecab.bean.WebsiteProfile;
import org.filecab.exception.SystemPersistenceException;
import org.filecab.persistence.dao.WebsiteProfileDao;
import org.filecab.util.EncryptionUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class WebsiteProfileManager {
	
	private WebsiteProfileDao dao;

	public List<WebsiteProfile> fetchAllProfiles(String userId) throws SystemPersistenceException {
		List<WebsiteProfile> profiles = dao.retrieveAllProfiles(userId);
		for (WebsiteProfile profile : profiles) {
			profile.setPassword(EncryptionUtils.decrypt(profile.getEncryptedPassword()));
		}
		return profiles;
	}

	public void setDao(WebsiteProfileDao dao) {
		this.dao = dao;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void storeProfile(WebsiteProfile profile) throws SystemPersistenceException {
		profile.setEncryptedPassword(
			EncryptionUtils.encrypt(profile.getPassword()));
		dao.saveProfile(profile);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void modifyProfile(WebsiteProfile profile) throws SystemPersistenceException {
		profile.setEncryptedPassword(
			EncryptionUtils.encrypt(profile.getPassword()));
		dao.updateProfile(profile);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void removeProfile(String key) throws SystemPersistenceException {
		dao.deleteProfile(key);
	}

}
