package org.filecab.business.manager;

import java.util.List;

import org.filecab.bean.DvdProfile;
import org.filecab.exception.SystemPersistenceException;
import org.filecab.persistence.dao.DvdProfileDao;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DvdProfileManager {

	private DvdProfileDao dao;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void storeProfile(DvdProfile profile) throws SystemPersistenceException {
		dao.saveProfile(profile);
	}

	public void setDao(DvdProfileDao dao) {
		this.dao = dao;
	}

	public List<DvdProfile> fetchAllProfiles(String userId) throws SystemPersistenceException {
		return dao.retrieveAllProfiles(userId);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void modifyProfile(DvdProfile selectedProfile) throws SystemPersistenceException {
		dao.updateProfile(selectedProfile);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void removeProfile(String id) throws SystemPersistenceException {
		dao.deleteProfile(id);
	}

}
