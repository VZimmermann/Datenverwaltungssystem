package org.intercard.template.data.db.dao.impl;

import javax.persistence.Query;

import org.intercard.template.data.db.dao.ILegicDao;
import org.intercard.template.data.db.domain.Legic;
import org.intercard.template.data.db.ex.DataException;

public class LegicDao extends AbstractDao<Legic> implements ILegicDao {

	@Override
	protected Class<Legic> getDomainClass() {
		return Legic.class;
	}

	@Override
	public Legic findLegic(String tName) throws DataException {

		Query q = entityManager.createNamedQuery("findLegic");
		q.setParameter("name", tName);

		// GENAU einer erwartet.
		return (Legic) q.getSingleResult();
	}
}
