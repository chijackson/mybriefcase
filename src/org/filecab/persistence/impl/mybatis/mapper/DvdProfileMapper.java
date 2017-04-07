package org.filecab.persistence.impl.mybatis.mapper;

import java.sql.SQLException;
import java.util.List;

import org.filecab.bean.DvdProfile;

public interface DvdProfileMapper {

	public void insertProfile(DvdProfile profile) throws SQLException;

	public List<DvdProfile> selectAllProfiles(String userId) throws SQLException;

	public void updateProfile(DvdProfile selectedProfile) throws SQLException;

	public void deleteProfile(String id) throws SQLException;

}
