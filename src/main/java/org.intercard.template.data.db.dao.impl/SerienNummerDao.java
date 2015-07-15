package org.intercard.template.data.db.dao.impl;

import javax.persistence.Query;

import org.intercard.template.data.db.dao.ISerienNummernDao;
import org.intercard.template.data.db.domain.SerienNummern;
import org.intercard.template.data.db.ex.DataException;

public class SerienNummernDao extends AbstractDao<SerienNummern> implements
		ISerienNummernDao {

	@Override
	protected Class<SerienNummern> getDomainClass() {
		return SerienNummern.class;
	}

	@Override
	public SerienNummern findSerienNummern(String tName) throws DataException {

		Query q = entityManager.createNamedQuery("findSerienNummern");
		q.setParameter("name", tName);

		// GENAU einer erwartet.
		return (SerienNummern) q.getSingleResult();
	}
}
