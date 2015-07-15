package org.intercard.template.data.db.dao;

import org.intercard.template.data.db.domain.Classic;
import org.intercard.template.data.db.ex.DataException;

public interface IClassicDao extends IDao<Classic> {

	public Classic findClassic(String tName) throws DataException;

}
