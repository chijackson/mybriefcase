/**
 * 
 */
package org.filecab.persistence.impl.mybatis.mapper;

import java.sql.SQLException;
import java.util.List;

import org.filecab.bean.WebsiteProfile;

/**
 * @author tso7924
 *
 */
public interface WebsiteProfileMapper {
	
	void insertProfile(WebsiteProfile profile) throws SQLException;
	
	List<WebsiteProfile> selectAllProfiles(String userId) throws SQLException;

	void updateProfile(WebsiteProfile profile) throws SQLException;

	void deleteProfile(String key) throws SQLException;
	
}
