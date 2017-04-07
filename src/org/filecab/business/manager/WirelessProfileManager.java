/**
 * 
 */
package org.filecab.business.manager;

import java.util.List;

import org.filecab.bean.WirelessProfile;
import org.filecab.exception.SystemPersistenceException;
import org.filecab.persistence.dao.WirelessProfileDao;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class WirelessProfileManager {

	private WirelessProfileDao dao;
	
	public List<WirelessProfile> fetchAllProfiles(String userId) throws SystemPersistenceException {
		return dao.retrieveAllProfiles(userId);
	}

	public void setDao(WirelessProfileDao dao) {
		this.dao = dao;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void storeProfile(WirelessProfile profile) throws SystemPersistenceException {
		dao.saveProfile(profile);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void removeProfile(String id) throws SystemPersistenceException {
		dao.deleteProfile(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void modifyProfile(WirelessProfile selectedProfile) throws SystemPersistenceException {
		dao.updateProfile(selectedProfile);
	}

}
