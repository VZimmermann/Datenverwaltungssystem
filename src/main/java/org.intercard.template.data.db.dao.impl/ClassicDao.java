package org.intercard.template.data.db.dao.impl;

import javax.persistence.Query;

import org.intercard.template.data.db.dao.IClassicDao;
import org.intercard.template.data.db.domain.Classic;
import org.intercard.template.data.db.ex.DataException;

public class ClassicDao extends AbstractDao<Classic> implements IClassicDao {

	@Override
	protected Class<Classic> getDomainClass() {
		return Classic.class;
	}

	@Override
	public Classic findClassic(String tName) throws DataException {

		Query q = entityManager.createNamedQuery("findClassic");
		q.setParameter("systemnummer", tName);

		// GENAU einer erwartet.
		return (Classic) q.getSingleResult();
	}
}
