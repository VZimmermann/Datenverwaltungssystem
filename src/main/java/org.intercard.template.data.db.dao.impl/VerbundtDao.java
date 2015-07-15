package org.intercard.template.data.db.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.intercard.template.data.db.dao.IVerbundDao;
import org.intercard.template.data.db.domain.Verbund;
import org.intercard.template.data.db.ex.DataException;

public class VerbundDao extends AbstractDao<Verbund> implements IVerbundDao {

	@Override
	protected Class<Verbund> getDomainClass() {
		return Verbund.class;
	}

	/** find a special Verbund by name */
	@Override
	public Verbund findVerbund(String name) throws DataException {

		Query q = entityManager.createNamedQuery("findVerbund");
		q.setParameter("name", name);

		// GENAU einer erwartet.
		return (Verbund) q.getSingleResult();
	}

	/** Find all existing Verbünde */
	@SuppressWarnings("unchecked")
	@Override
	public List<Verbund> findAllVerbund() throws DataException {
		Query q = entityManager.createNamedQuery("findAllVerbund");
		return (List<Verbund>) q.getResultList();
	}

	/** Find a Verbund with its Teilnehmer */
	@Override
	public Verbund findVerbundWithTeilnehmer(String tName) throws DataException {

		Query q = entityManager.createNamedQuery("findVerbundWithTeilnehmer");
		q.setParameter("name", tName);

		// GENAU einer erwartet.
		return (Verbund) q.getSingleResult();
	}

}
