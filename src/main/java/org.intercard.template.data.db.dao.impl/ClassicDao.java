package org.intercard.template.data.db.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.intercard.template.data.db.dao.IClassicDao;
import org.intercard.template.data.db.domain.Classic;
import org.intercard.template.data.db.ex.DataException;

public class ClassicDao extends AbstractDao<Classic> implements IClassicDao {

	@Override
	protected Class<Classic> getDomainClass() {
		return Classic.class;
	}

	/** Find all active Classic cardtechnologies */
	@Override
	public Classic findActivClassic(boolean activ) throws DataException {

		Query q = entityManager.createNamedQuery("findActivClassic");
		q.setParameter("activ", activ);

		// GENAU einer erwartet.
		return (Classic) q.getSingleResult();
	}

	/** Find all Classic cards */
	@Override
	public Classic findClassicbyID(String id) throws DataException {
		Query q = entityManager.createNamedQuery("findClassicbyID");
		q.setParameter("systemnummergesamt", id);

		// GENAU einer erwartet
		return (Classic) q.getSingleResult();
	}

	/** Find classic by N1V/N1A/N2/N3 connected to String */
	@SuppressWarnings("unchecked")
	@Override
	public List<Classic> findAllClassic() throws DataException {
		Query q = entityManager.createNamedQuery("findAllClassic");

		return (List<Classic>) q.getResultList();
	}
}
