/**
 * 
 */
package org.filecab.business.manager;

import java.util.List;

import org.filecab.bean.CodeValue;
import org.filecab.exception.SystemPersistenceException;
import org.filecab.persistence.dao.CodeValueDao;

/**
 * @author tso7924
 *
 */
public class DropDownManager {
	
	private CodeValueDao dao;

	public DropDownManager() {
	}
	
	public CodeValueDao getDao() {
		return dao;
	}

	public void setDao(CodeValueDao dao) {
		this.dao = dao;
	}
	
	public List<CodeValue> fetchGigahertz() throws SystemPersistenceException {
		return dao.retrieveGigahertz();
	}

}
