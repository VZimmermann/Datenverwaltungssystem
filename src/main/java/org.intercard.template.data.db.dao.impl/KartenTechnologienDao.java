package org.intercard.template.data.db.dao.impl;

import javax.persistence.Query;

import org.intercard.template.data.db.dao.IKartenTechnologienDao;
import org.intercard.template.data.db.domain.KartenTechnologien;
import org.intercard.template.data.db.ex.DataException;

public class KartenTechnologienDao extends AbstractDao<KartenTechnologien>
		implements IKartenTechnologienDao {

	@Override
	protected Class<KartenTechnologien> getDomainClass() {
		return KartenTechnologien.class;
	}

	@Override
	public KartenTechnologien findKartentechnologien(String tName)
			throws DataException {

		Query q = entityManager.createNamedQuery("findKartentechnology");
		q.setParameter("name", tName);

		// GENAU einer erwartet.
		return (KartenTechnologien) q.getSingleResult();
	}
}
