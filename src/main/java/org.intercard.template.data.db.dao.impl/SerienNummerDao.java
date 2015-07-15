package org.intercard.template.data.db.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.intercard.template.data.db.dao.ISerienNummerDao;
import org.intercard.template.data.db.domain.SerienNummer;
import org.intercard.template.data.db.ex.DataException;

public class SerienNummerDao extends AbstractDao<SerienNummer> implements
		ISerienNummerDao {

	@Override
	protected Class<SerienNummer> getDomainClass() {
		return SerienNummer.class;
	}

	/** Find all Seriennummern */
	@SuppressWarnings("unchecked")
	@Override
	public List<SerienNummer> findAllSeriennummern() throws DataException {
		Query q = entityManager.createNamedQuery("findAllSeriennummern");
		return (List<SerienNummer>) q.getResultList();
	}

	/**
	 * Find Seriennummernbereiche (Ranges)-->Wenn man die erste Nummer hat wird
	 * die Anzahl angezeigt
	 */
	@Override
	public SerienNummer findSeriennummeranfang(Long snanfang)
			throws DataException {
		Query q = entityManager.createNamedQuery("findSeriennummerbySNAnfang");
		q.setParameter("snanfang", snanfang);

		return (SerienNummer) q.getSingleResult();
	}

	/** Find Seriennummern with a special date when they were created */
	@Override
	public SerienNummer findSeriennummerbydate(Date date) throws DataException {
		Query q = entityManager.createNamedQuery("findSeriennummerbyDate");
		q.setParameter("date", date);

		return (SerienNummer) q.getSingleResult();
	}

}
