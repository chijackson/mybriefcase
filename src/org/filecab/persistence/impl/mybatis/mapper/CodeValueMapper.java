/**
 * 
 */
package org.filecab.persistence.impl.mybatis.mapper;

import java.sql.SQLException;
import java.util.List;

import org.filecab.bean.CodeValue;

/**
 * @author tso7924
 *
 */
public interface CodeValueMapper {

	List<CodeValue> selectGigahertzValues() throws SQLException;
	
}
