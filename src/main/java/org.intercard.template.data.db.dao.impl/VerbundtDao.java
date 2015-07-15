package org.intercard.template.data.db.dao.impl;

import javax.persistence.Query;

import org.intercard.template.data.db.dao.IVerbundDao;
import org.intercard.template.data.db.domain.Verbund;
import org.intercard.template.data.db.ex.DataException;

public class VerbundDao extends AbstractDao<Verbund> implements IVerbundDao {

	@Override
	protected Class<Verbund> getDomainClass() {
		return Verbund.class;
	}

	@Override
	public Verbund findVerbund(String tName) throws DataException {

		Query q = entityManager.createNamedQuery("findVerbund");
		q.setParameter("name", tName);

		// GENAU einer erwartet.
		return (Verbund) q.getSingleResult();
	}

	@Override
	public Verbund getVerbundWithTeilnehmer(String tName) throws DataException {

		Query q = entityManager.createNamedQuery("findVerbundWithTeilnehmer");
		q.setParameter("name", tName);

		// GENAU einer erwartet.
		return (Verbund) q.getSingleResult();
	}

}
