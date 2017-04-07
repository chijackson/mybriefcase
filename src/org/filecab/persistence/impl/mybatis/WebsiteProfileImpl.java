/**
 * 
 */
package org.filecab.persistence.impl.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.filecab.bean.WebsiteProfile;
import org.filecab.exception.SystemPersistenceException;
import org.filecab.persistence.dao.WebsiteProfileDao;
import org.filecab.persistence.impl.mybatis.mapper.WebsiteProfileMapper;
import org.springframework.dao.DataAccessException;

/**
 * @author tso7924
 *
 */
public class WebsiteProfileImpl implements WebsiteProfileDao {

	private WebsiteProfileMapper mapper;
	
	@Override
	public void saveProfile(WebsiteProfile profile)	throws SystemPersistenceException {
		try {
			mapper.insertProfile(profile);
		} catch (PersistenceException pe) {
			throw new SystemPersistenceException(pe);
		} catch (SQLException sqle) {
			throw new SystemPersistenceException(sqle);
		} catch (DataAccessException daex) {
			throw new SystemPersistenceException(daex);
		}
	}

	@Override
	public void deleteProfile(String key) throws SystemPersistenceException {
		try {
			mapper.deleteProfile(key);
		} catch (PersistenceException pe) {
			throw new SystemPersistenceException(pe);
		} catch (SQLException sqle) {
			throw new SystemPersistenceException(sqle);
		} catch (DataAccessException daex) {
			throw new SystemPersistenceException(daex);
		}
	}

	@Override
	public void updateProfile(WebsiteProfile profile) throws SystemPersistenceException {
		try {
			mapper.updateProfile(profile);
		} catch (PersistenceException pe) {
			throw new SystemPersistenceException(pe);
		} catch (SQLException sqle) {
			throw new SystemPersistenceException(sqle);
		} catch (DataAccessException daex) {
			throw new SystemPersistenceException(daex);
		}
	}

	@Override
	public List<WebsiteProfile> retrieveAllProfiles(String userId) throws SystemPersistenceException {
		try {
			return mapper.selectAllProfiles(userId);
		} catch (PersistenceException pe) {
			throw new SystemPersistenceException(pe);
		} catch (SQLException sqle) {
			throw new SystemPersistenceException(sqle);
		} catch (DataAccessException daex) {
			throw new SystemPersistenceException(daex);
		}
	}

	public WebsiteProfileMapper getMapper() {
		return mapper;
	}

	public void setMapper(WebsiteProfileMapper mapper) {
		this.mapper = mapper;
	}

}
