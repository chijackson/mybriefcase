/**
 * 
 */
package org.filecab.persistence.dao;

import java.util.List;

import org.filecab.bean.WebsiteProfile;
import org.filecab.exception.SystemPersistenceException;

/**
 * @author tso7924
 *
 */
public interface WebsiteProfileDao {
	
	void saveProfile(WebsiteProfile profile) throws SystemPersistenceException;
	
	void deleteProfile(String key) throws SystemPersistenceException;
	
	void updateProfile(WebsiteProfile profile) throws SystemPersistenceException;
	
	List<WebsiteProfile> retrieveAllProfiles(String userId) throws SystemPersistenceException;
	
}
