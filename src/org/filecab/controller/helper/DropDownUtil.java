/**
 * 
 */
package org.filecab.controller.helper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.filecab.bean.CodeValue;
import org.filecab.business.manager.DropDownManager;
import org.filecab.exception.SystemPersistenceException;
import org.filecab.util.ApplicationBeanFactory;

/**
 * @author tso7924
 *
 */
public final class DropDownUtil {

	public static List<SelectItem> getGigahertzValues() {
		List<SelectItem> values = new ArrayList<SelectItem>();
		DropDownManager manager = (DropDownManager) ApplicationBeanFactory.getBean(DropDownManager.class);
		List<CodeValue> gigahertzs = null;
		
		try {
			gigahertzs = manager.fetchGigahertz();
		} catch (SystemPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (CodeValue bean : gigahertzs) {
			values.add(new SelectItem(bean.getCode(), bean.getValue()));
		}
		
		return values;
	}
}
