/**
 * 
 */
package org.filecab.persistence.impl.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.filecab.bean.CodeValue;
import org.filecab.exception.SystemPersistenceException;
import org.filecab.persistence.dao.CodeValueDao;
import org.filecab.persistence.impl.mybatis.mapper.CodeValueMapper;
import org.springframework.dao.DataAccessException;

/**
 * @author tso7924
 *
 */
public class CodeValueImpl implements CodeValueDao {

	private CodeValueMapper mapper;
	
	/* (non-Javadoc)
	 * @see org.filecab.persistence.dao.CodeValueDao#retrieveGigahertz()
	 */
	@Override
	public List<CodeValue> retrieveGigahertz() throws SystemPersistenceException {
		try {
			return mapper.selectGigahertzValues();
		} catch (PersistenceException pe) {
			throw new SystemPersistenceException(pe);
		} catch (SQLException sqle) {
			throw new SystemPersistenceException(sqle);
		} catch (DataAccessException daex) {
			throw new SystemPersistenceException(daex);
		}
	}

	public CodeValueMapper getMapper() {
		return mapper;
	}

	public void setMapper(CodeValueMapper mapper) {
		this.mapper = mapper;
	}

}
