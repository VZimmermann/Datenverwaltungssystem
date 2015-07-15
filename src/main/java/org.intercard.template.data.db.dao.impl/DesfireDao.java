package org.intercard.template.data.db.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.intercard.template.data.db.dao.IDesfireDao;
import org.intercard.template.data.db.domain.Desfire;
import org.intercard.template.data.db.ex.DataException;

public class DesfireDao extends AbstractDao<Desfire> implements IDesfireDao {

	@Override
	protected Class<Desfire> getDomainClass() {
		return Desfire.class;
	}

	/** Find Desfire by N1V/N1A/N2/N3 connected to String */
	@Override
	public Desfire findDesfirebyID(String id) throws DataException {

		Query q = entityManager.createNamedQuery("findDesfirebyID");
		q.setParameter("name", id);

		// GENAU einer erwartet.
		return (Desfire) q.getSingleResult();
	}

	/** Find all active Desfire Cardtechnologies */
	@Override
	public Desfire findActivDesfire(boolean activ) throws DataException {
		Query q = entityManager.createNamedQuery("findActivDesfire");
		q.setParameter("activ", activ);
		return (Desfire) q.getSingleResult();
	}

	/** Find all Desfire Cardtechnologies */
	@SuppressWarnings("unchecked")
	@Override
	public List<Desfire> findAllDesfire() throws DataException {
		Query q = entityManager.createNamedQuery("findAllDesfire");
		return (List<Desfire>) q.getResultList();
	}
}
