package org.intercard.template.data.db.dao;

import java.util.List;

import org.intercard.template.data.db.domain.Legic;
import org.intercard.template.data.db.ex.DataException;

public interface ILegicDao extends IDao<Legic> {

	/** Find all active Legic cardtechnologies */
	public Legic findActivLegic(boolean activ) throws DataException;

	/** Find Legic by N1V/N1A/N2/N3 connected to String */
	public Legic findLegicbyID(String id) throws DataException;

	/** Find all Legic cards */
	public List<Legic> findAllLegic() throws DataException;
}
