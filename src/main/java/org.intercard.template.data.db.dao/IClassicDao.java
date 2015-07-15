package org.intercard.template.data.db.dao;

import java.util.List;

import org.intercard.template.data.db.domain.Classic;
import org.intercard.template.data.db.ex.DataException;

public interface IClassicDao extends IDao<Classic> {

	/** Find all active Classic cardtechnologies */
	public Classic findActivClassic(boolean activ) throws DataException;

	/** Find classic by N1V/N1A/N2/N3 connected to String */
	public Classic findClassicbyID(String id) throws DataException;

	/** Find all Classic cards */
	public List<Classic> findAllClassic() throws DataException;
}
