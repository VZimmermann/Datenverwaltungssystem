package org.intercard.template.data.db.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.intercard.template.data.db.dao.ILegicDao;
import org.intercard.template.data.db.domain.Legic;
import org.intercard.template.data.db.ex.DataException;

public class LegicDao extends AbstractDao<Legic> implements ILegicDao {

	@Override
	protected Class<Legic> getDomainClass() {
		return Legic.class;
	}

	//
	// /** Find Legic by N1V/N1A/N2/N3 connected to String */
	// @Override
	// public Legic findLegicbyID(String id) throws DataException {
	//
	// Query q = entityManager.createNamedQuery("findLegicbyID");
	// q.setParameter("systemnummergesamt", id);
	//
	// // GENAU einer erwartet.
	// return (Legic) q.getSingleResult();
	// }

	/** Find all active Legic cardtechnologies */

	@Override
	public Legic findActivLegic(boolean aktiv) throws DataException {
		Query q = entityManager.createNamedQuery("findActiveLegic");
		q.setParameter("activ", aktiv);
		return (Legic) q.getSingleResult();
	}

	/** Find all Legic cards */
	@SuppressWarnings("unchecked")
	@Override
	public List<Legic> findAllLegic() throws DataException {
		Query q = entityManager.createNamedQuery("findAllLegic");
		return (List<Legic>) q.getResultList();
	}
}
