package org.intercard.template.service.impl;

import java.util.List;

import org.intercard.template.data.db.dao.IKundeDao;
import org.intercard.template.data.db.domain.Kunde;
import org.intercard.template.data.db.ex.DataException;
import org.intercard.template.service.IKundeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KundeService implements IKundeService {

	private static final Logger logger = LoggerFactory
			.getLogger(KundeService.class);

	private IKundeDao kundeDao;

	/** Create a new Kunde */
	@Override
	public Kunde createKunde(Kunde kunde) {
		if (kunde != null) {
			try {
				kundeDao.doSave(kunde);
				logger.debug("Service Create Kunde");
				return kunde;
			} catch (DataException e) {
				logger.debug("EX", e);
			}
		}
		return null;
	}

	/** Delete Data from a Kunde */
	@Override
	public Kunde deleteKunde(Kunde kunde) {
		if (kunde != null && kunde.getId() != 0) {
			try {
				kundeDao.doDelete(kunde);
				logger.debug("Service Delete Kunde");
				return kunde;
			} catch (DataException e) {
				logger.debug("EX", e);
			}
		}
		return null;
	}

	/** update an excisting Kunde */
	@Override
	public Kunde updateKunde(Kunde kunde) {
		if (kunde != null && kunde.getId() != 0) {
			try {
				kundeDao.doUpdate(kunde);
				logger.debug("Service Update Kunde");
				return kunde;
			} catch (DataException e) {
				logger.debug("EX", e);
			}
		}
		return null;
	}

	/** get a List with all Kunden */
	@Override
	public List<Kunde> getKundeList() {
		try {
			List<Kunde> kunde = kundeDao.findKunde();
			// isEmpty überprüft ob kun initialisiert wurde
			if (kunde != null && !kunde.isEmpty())
				return kunde;

		} catch (DataException e) {
			logger.debug("List is empty", e);
		}
		return null;
	}

	// @Override
	// public List<Kunde> getKundenInLaender() {
	//
	// return null;
	// }

	/** get a List with possible Kunden after searching a name */
	@Override
	public List<Kunde> getKunden(String searchName) {

		try {
			List<Kunde> kunstr = kundeDao.findbyName(searchName);
			if (kunstr != null && !kunstr.isEmpty())
				return kunstr;
		} catch (DataException e) {
			logger.debug("Kein Kunde vorhanden", e);
		}
		return null;
	}

	/** get a Kunde by id */
	@Override
	public Kunde getKunde(int kundenid) {
		if (kundenid != 0) {
			try {
				Kunde kunid = kundeDao.findById(kundenid);
				return kunid;
			} catch (DataException e) {
				logger.debug("Kein Kunde mit der ID gefunden", e);
			}
		}
		return null;
	}

	/**
	 * get a Kunde and Verbundsschluessel, Kunde and Kartentechnologien, Kunde
	 * and Seriennummern by searching a id
	 */
	@Override
	public Kunde getKundeWithVerbundschluessel(int kundenid) {
		if (kundenid != 0) {
			try {
				Kunde kundever = kundeDao.findWithVerbundschluessel(kundenid);
				return kundever;
			} catch (DataException e) {
				logger.debug("Kein Kunde mit dieser ID gefunden");
			}
		}
		return null;
	}

	@Override
	public Kunde getKundeWithKartentechnologien(int kundenid) {
		if (kundenid != 0) {
			try {
				Kunde kundekart = kundeDao.findWithBags(kundenid);
				return kundekart;
			} catch (DataException e) {
				logger.debug("Kein Ergebnis", e);
			}
		}
		return null;
	}

	public List<Kunde> getKundeWithKartentechList() {
		try {
			List<Kunde> kundelist = kundeDao.findAllWithBags();
			if (kundelist != null && !kundelist.isEmpty())
				return kundelist;
		} catch (DataException e) {
			logger.debug("Kein Ergebnis", e);
		}
		return null;
	}

	@Override
	public Kunde getKundeWithSeriennummern(int kundenid) {
		if (kundenid != 0) {
			try {
				Kunde kundeser = kundeDao.findWithSeriennummern(kundenid);
				return kundeser;
			} catch (DataException e) {
				logger.debug("Kein Ergebnis", e);
			}
		}

		return null;
	}

	public IKundeDao getKundeDao() {
		return kundeDao;
	}

	public void setKundeDao(IKundeDao kundeDao) {
		this.kundeDao = kundeDao;
	}

}
