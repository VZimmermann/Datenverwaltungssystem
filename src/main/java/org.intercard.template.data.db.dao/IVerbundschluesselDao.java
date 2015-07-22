package org.intercard.template.data.db.dao;

import org.intercard.template.data.db.domain.Verbundschluessel;

public interface IVerbundschluesselDao extends IDao<Verbundschluessel> {

	public List<Verbundschluessel> findSchluessel() throws DataException;

}
