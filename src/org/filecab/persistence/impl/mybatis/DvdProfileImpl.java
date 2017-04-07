package org.filecab.persistence.impl.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.filecab.bean.DvdProfile;
import org.filecab.exception.SystemPersistenceException;
import org.filecab.persistence.dao.DvdProfileDao;
import org.filecab.persistence.impl.mybatis.mapper.DvdProfileMapper;
import org.springframework.dao.DataAccessException;

public class DvdProfileImpl implements DvdProfileDao {

	private DvdProfileMapper mapper;
	
	/* (non-Javadoc)
	 * @see org.filecab.persistence.dao.DvdProfileDao#saveProfile(org.filecab.bean.DvdProfile)
	 */
	public void saveProfile(DvdProfile profile) throws SystemPersistenceException {
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

	public DvdProfileMapper getMapper() {
		return mapper;
	}

	public void setMapper(DvdProfileMapper mapper) {
		this.mapper = mapper;
	}

	/* (non-Javadoc)
	 * @see org.filecab.persistence.dao.DvdProfileDao#retrieveAllProfiles(java.lang.String)
	 */
	public List<DvdProfile> retrieveAllProfiles(String userId) throws SystemPersistenceException {
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

	/* (non-Javadoc)
	 * @see org.filecab.persistence.dao.DvdProfileDao#updateProfile(org.filecab.bean.DvdProfile)
	 */
	public void updateProfile(DvdProfile selectedProfile) throws SystemPersistenceException {
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

	/* (non-Javadoc)
	 * @see org.filecab.persistence.dao.DvdProfileDao#deleteProfile(java.lang.String)
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

}
