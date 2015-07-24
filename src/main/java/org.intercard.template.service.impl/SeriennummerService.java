package org.intercard.template.service.impl;

import java.util.List;

import org.intercard.template.data.db.dao.IKundeDao;
import org.intercard.template.data.db.dao.ISerienNummerDao;
import org.intercard.template.data.db.domain.Kunde;
import org.intercard.template.data.db.domain.SerienNummer;
import org.intercard.template.data.db.ex.DataException;
import org.intercard.template.service.ISeriennummerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeriennummerService implements ISeriennummerService {

	private static final Logger logger = LoggerFactory
			.getLogger(SeriennummerService.class);

	private ISerienNummerDao seriennummerDao;
	private IKundeDao kundeDao;

	/** reserve a Range for a Kunde or Create a new Range */
	public SerienNummer reserveSeriennummernRange(Kunde kunde, int snanfang,
			int snende) {
		SerienNummer sernum = new SerienNummer();
		if (kunde != null && snende != 0 && snanfang != 0) {
			try {

				// sernum.setAnzahl(anzahl);
				sernum.setSnanfang(snanfang);
				sernum.setSnende(snende);
				sernum.setKunde(kunde);

				seriennummerDao.doSave(sernum);
				kundeDao.doUpdate(kunde);
				logger.debug("Reservierung war erfolgreich");
				return sernum;
			} catch (DataException e) {
				logger.debug("Konnte nicht reserviert werden");
			}
		}
		return null;
	}

	/** get a Seriennummer by its beginning */
	public SerienNummer getSeriennummer(int snanfang) {

		if (snanfang != 0) {
			try {
				SerienNummer sernum = seriennummerDao.findOne(snanfang);
				return sernum;
			} catch (DataException e) {
				logger.debug("Kein Ergebnis", e);
			}
		}
		return null;
	}

	/** get a List of Seriennummern */
	@Override
	public List<SerienNummer> getSeriennummernList() {
		try {
			List<SerienNummer> serlist = seriennummerDao.findAllSeriennummern();
			if (serlist != null && !serlist.isEmpty())
				;
			return serlist;
		} catch (DataException e) {
			logger.debug("Keine Seriennummern gefunden", e);
		}
		return null;
	}

	/** Delete a Range */
	@Override
	public boolean deleteSeriennummern(SerienNummer seriennummern) {
		if (seriennummern != null && seriennummern.getSnanfang() != 0
				&& seriennummern.getSnende() != 0) {
			try {
				seriennummerDao.doDelete(seriennummern);
				return true;
			} catch (DataException e) {
				logger.debug("Konnte nicht gelöscht werden");
			}
		}
		return false;
	}

	/*
	 * // nächste freie Seriennummer berechen private SerienNummer
	 * nextfreeSerienNummer(int anzahl) { // Query q = Select MAX(snanfang) from
	 * SerienNummer s // int nextserum = q.getSingleResult();
	 * 
	 * // Query q = EntityManagerBuilder //
	 * .createQuery("Select Max(snanfang) from SerienNummer"); //
	 * TypedQuery<SerienNummer> q = EntityManager.createQuery( //
	 * "Select Max(snanfang) from SerienNUmmer s", SerienNummer.class); return
	 * seriennummer; }
	 */

	// @Override
	// public int lastSerienNummer(int snende) {
	// int lastseriennummer =
	// }
	public ISerienNummerDao getSeriennummerDao() {
		return seriennummerDao;
	}

	public void setSeriennummerDao(ISerienNummerDao seriennummerDao) {
		this.seriennummerDao = seriennummerDao;
	}

}
