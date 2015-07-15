package org.intercard.template.data.db.dao;

import org.intercard.template.data.db.domain.Verbund;
import org.intercard.template.data.db.ex.DataException;

public interface IVerbundDao extends IDao<Verbund> {

	public Verbund findVerbund(String tName) throws DataException;

	public Verbund getVerbundWithTeilnehmer(String tName) throws DataException;

}
