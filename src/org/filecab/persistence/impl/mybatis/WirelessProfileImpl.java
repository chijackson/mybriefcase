/**
 * 
 */
package org.filecab.persistence.impl.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.filecab.bean.WirelessProfile;
import org.filecab.exception.SystemPersistenceException;
import org.filecab.persistence.dao.WirelessProfileDao;
import org.filecab.persistence.impl.mybatis.mapper.WirelessProfileMapper;
import org.springframework.dao.DataAccessException;

/**
 * @author tso7924
 *
 */
public class WirelessProfileImpl implements WirelessProfileDao {

	private WirelessProfileMapper mapper;
	
	/* (non-Javadoc)
	 * @see org.filecab.persistence.dao.WirelessProfileDao#retrieveAllProfiles(java.lang.String)
	 */
	public List<WirelessProfile> retrieveAllProfiles(String userId) throws SystemPersistenceException {
		try {
			return getMapper().selectAllProfiles(userId);
		} catch (PersistenceException pe) {
			throw new SystemPersistenceException(pe);
		} catch (SQLException sqle) {
			throw new SystemPersistenceException(sqle);
		} catch (DataAccessException daex) {
			throw new SystemPersistenceException(daex);
		}
	}

	public WirelessProfileMapper getMapper() {
		return mapper;
	}

	public void setMapper(WirelessProfileMapper mapper) {
		this.mapper = mapper;
	}

	/* (non-Javadoc)
	 * @see org.filecab.persistence.dao.WirelessProfileDao#saveProfile(org.filecab.bean.WirelessProfile)
	 */
	public void saveProfile(WirelessProfile profile) throws SystemPersistenceException {
		try {
			getMapper().insertProfile(profile);
		} catch (PersistenceException pe) {
			throw new SystemPersistenceException(pe);
		} catch (SQLException sqle) {
			throw new SystemPersistenceException(sqle);
		} catch (DataAccessException daex) {
			throw new SystemPersistenceException(daex);
		}
	}

	/* (non-Javadoc)
	 * @see org.filecab.persistence.dao.WirelessProfileDao#deleteProfile(java.lang.String)
	 */
	public void deleteProfile(String id) throws SystemPersistenceException {
		try {
			getMapper().deleteProfile(id);
		} catch (PersistenceException pe) {
			throw new SystemPersistenceException(pe);
		} catch (SQLException sqle) {
			throw new SystemPersistenceException(sqle);
		} catch (DataAccessException daex) {
			throw new SystemPersistenceException(daex);
		}
	}

	/* (non-Javadoc)
	 * @see org.filecab.persistence.dao.WirelessProfileDao#updateProfile(org.filecab.bean.WirelessProfile)
	 */
	public void updateProfile(WirelessProfile selectedProfile) throws SystemPersistenceException {
		try {
			getMapper().updateProfile(selectedProfile);
		} catch (PersistenceException pe) {
			throw new SystemPersistenceException(pe);
		} catch (SQLException sqle) {
			throw new SystemPersistenceException(sqle);
		} catch (DataAccessException daex) {
			throw new SystemPersistenceException(daex);
		}
	}

}
