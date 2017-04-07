/**
 * 
 */
package org.filecab.persistence.impl.mybatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.filecab.bean.User;
import org.filecab.exception.SystemPersistenceException;
import org.filecab.persistence.dao.UserDao;
import org.filecab.persistence.impl.mybatis.mapper.UserMapper;
import org.springframework.dao.DataAccessException;

/**
 * @author tso7924
 *
 */
public class UserImpl implements UserDao {
	
	private UserMapper mapper;

	/* (non-Javadoc)
	 * @see org.filecab.persistence.dao.UserDao#retrieveUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User retrieveUser(String userId, String password) throws SystemPersistenceException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userId);
		map.put("passw", password);
		try {
			return getMapper().selectUser(map);
		} catch (PersistenceException pe) {
			throw new SystemPersistenceException(pe);
		} catch (SQLException sqle) {
			throw new SystemPersistenceException(sqle);
		} catch (DataAccessException daex) {
			throw new SystemPersistenceException(daex);
		}
	}

	public UserMapper getMapper() {
		return mapper;
	}

	public void setMapper(UserMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public void saveUser(User user) throws SystemPersistenceException {
		try {
			mapper.insertUser(user);
		} catch (PersistenceException pe) {
			throw new SystemPersistenceException(pe);
		} catch (SQLException sqle) {
			throw new SystemPersistenceException(sqle);
		} catch (DataAccessException daex) {
			throw new SystemPersistenceException(daex);
		}
	}


}
