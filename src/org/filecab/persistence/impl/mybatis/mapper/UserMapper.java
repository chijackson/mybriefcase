/**
 * 
 */
package org.filecab.persistence.impl.mybatis.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.filecab.bean.User;

/**
 * @author tso7924
 *
 */
public interface UserMapper {

	User selectUser(Map<String, String> paramaters) throws SQLException;

	void insertUser(User user) throws SQLException;
	
}
