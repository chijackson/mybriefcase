package org.filecab.persistence.dao;

import java.util.List;

import org.filecab.bean.DvdProfile;
import org.filecab.exception.SystemPersistenceException;

public interface DvdProfileDao {

	void saveProfile(DvdProfile profile) throws SystemPersistenceException;

	List<DvdProfile> retrieveAllProfiles(String userId) throws SystemPersistenceException;

	void updateProfile(DvdProfile selectedProfile) throws SystemPersistenceException;

	void deleteProfile(String id) throws SystemPersistenceException;
	
}
