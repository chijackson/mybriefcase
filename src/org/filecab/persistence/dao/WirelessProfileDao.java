/**
 * 
 */
package org.filecab.persistence.dao;

import java.util.List;

import org.filecab.bean.WirelessProfile;
import org.filecab.exception.SystemPersistenceException;

public interface WirelessProfileDao {

	List<WirelessProfile> retrieveAllProfiles(String userId) throws SystemPersistenceException;

	void saveProfile(WirelessProfile profile) throws SystemPersistenceException;

	void deleteProfile(String id) throws SystemPersistenceException;

	void updateProfile(WirelessProfile selectedProfile) throws SystemPersistenceException;

}
