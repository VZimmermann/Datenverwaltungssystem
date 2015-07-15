package org.intercard.template.data.db.dao.impl;

import javax.persistence.Query;

import org.intercard.template.data.db.dao.IDesfireDao;
import org.intercard.template.data.db.domain.Desfire;
import org.intercard.template.data.db.ex.DataException;

public class DesfireDao extends AbstractDao<Desfire> implements IDesfireDao {

	@Override
	protected Class<Desfire> getDomainClass() {
		return Desfire.class;
	}

	@Override
	public Desfire findDesfire(String tName) throws DataException {

		Query q = entityManager.createNamedQuery("findDesfire");
		q.setParameter("name", tName);

		// GENAU einer erwartet.
		return (Desfire) q.getSingleResult();
	}
}
