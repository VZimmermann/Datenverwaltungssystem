package org.intercard.template.data.db.dao;

import java.util.List;

import org.intercard.template.data.db.domain.Verbund;
import org.intercard.template.data.db.ex.DataException;

public interface IVerbundDao extends IDao<Verbund> {

	/** Find all existing Verbünde */
	public List<Verbund> findAllVerbund() throws DataException;

	/** find a special Verbund by name */
	public Verbund findVerbund(String name) throws DataException;

	/** Find a Verbund with its Teilnehmer */
	public Verbund findVerbundWithTeilnehmer(String tName) throws DataException;

}
