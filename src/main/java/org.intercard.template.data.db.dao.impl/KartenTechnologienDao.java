package org.intercard.template.data.db.dao.impl;

import java.util.List;

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

	/** find all existing CardTechnologies with type KartenTechnologie */
	@SuppressWarnings("unchecked")
	@Override
	public List<KartenTechnologien> findKartentechnologien()
			throws DataException {

		Query q = entityManager.createNamedQuery("findKartentechnologien");
		return (List<KartenTechnologien>) q.getResultList();
	}
}
