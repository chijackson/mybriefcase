/**
 * 
 */
package org.filecab.persistence.dao;

import java.util.List;

import org.filecab.bean.CodeValue;
import org.filecab.exception.SystemPersistenceException;

/**
 * @author tso7924
 *
 */
public interface CodeValueDao {

	List<CodeValue> retrieveGigahertz()  throws SystemPersistenceException;
}
