package org.filecab.persistence.impl.mybatis.mapper;

import java.sql.SQLException;
import java.util.List;

import org.filecab.bean.WirelessProfile;

public interface WirelessProfileMapper {

	List<WirelessProfile> selectAllProfiles(String userId) throws SQLException;

	void insertProfile(WirelessProfile profile) throws SQLException;

	void deleteProfile(String id) throws SQLException;

	void updateProfile(WirelessProfile selectedProfile) throws SQLException;

}
