package org.intercard.template.data.db.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.intercard.template.data.db.dao.IKundeDao;
import org.intercard.template.data.db.domain.Kunde;
import org.intercard.template.data.db.ex.DataException;

public class KundeDao extends AbstractDao<Kunde> implements IKundeDao {

	@Override
	protected Class<Kunde> getDomainClass() {
		return Kunde.class;
	}

	/** find all Clients by Name */
	@Override
	public Kunde findbyName(String tName) throws DataException {

		Query q = entityManager.createNamedQuery("findKundebyName");
		q.setParameter("name", tName);

		// GENAU einer erwartet.
		return (Kunde) q.getSingleResult();
	}

	/**
	 * Kunde joinen with KartenTechnologien, find Kunde with its
	 * Cardtechnologies
	 */
	@Override
	public Kunde findWithBags(int id) throws DataException {

		Query q = entityManager.createNamedQuery("findKundeWithBags");
		q.setParameter("id", id);

		// GENAU einer erwartet.
		return (Kunde) q.getSingleResult();
	}

	/** if there is a warning don't show it */
	@SuppressWarnings("unchecked")
	@Override
	public List<Kunde> findAllWithBags() throws DataException {

		Query q = entityManager.createNamedQuery("findAllKundeWithBags");

		// GENAU einer erwartet.
		return (List<Kunde>) q.getResultList();
	}

	/** Find a client and his Seriennummern */

	@Override
	public Kunde findWithSeriennummern(int id) throws DataException {
		Query q = entityManager.createNamedQuery("findKundeWithSeriennummer");
		q.setParameter("id", id);
		return (Kunde) q.getSingleResult();
	}

	/** Find a client and his Verbundschluessel */

	@Override
	public Kunde findWithVerbundschluessel(int id) throws DataException {
		Query q = entityManager
				.createNamedQuery("findKundeWithVerbundschluessel");
		q.setParameter("id", id);
		return (Kunde) q.getSingleResult();
	}

}
