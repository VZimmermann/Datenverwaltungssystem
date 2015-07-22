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

	@Override
	public List<Kunde> getLaenderkuerzelList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createCustomer(Kunde kunde) {
		if (kunde != null) {
			try {
				kundeDao.doSave(kunde);
				logger.debug(" Service Create Kunde");
				return true;
			} catch (DataException e) {
				logger.debug("EX", e);
			}
		}
		return false;
	}

	@Override
	public boolean deleteCustomer(Kunde kunde) {
		if (kunde != null && kunde.getId() != 0) {
			try {
				kundeDao.doDelete(kunde);
				logger.debug(" Service Delete Kunde");
				return true;
			} catch (DataException e) {
				logger.debug("EX", e);
			}
		}
		return false;
	}

	@Override
	public boolean updateCustomer(Kunde kunde) {
		if (kunde != null && kunde.getId() != 0) {
			try {
				kundeDao.doUpdate(kunde);
				logger.debug(" Service Update Kunde");
				return true;
			} catch (DataException e) {
				logger.debug("EX", e);
			}
		}
		return false;
	}

	@Override
	public List<Kunde> getKundeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Kunde getKunde(String kundenname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Kunde getKunde(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Kunde getSAPnr(String sapkundennr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Kunde getSAPstatus(String sapstatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Kunde getHochschulregionnummer(String hochschulregionnummer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Kunde getHochschulnummer(String hochschulnummer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Kunde getFremdsystemnummer(String fremdsystemnummer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Kunde getkommentar(String kommentar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setkommentar(String kommentar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Kunde> getKundeWithVerbundschluessel() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * SETTER FOR SPRING CONFIG
	 */
	public void setKundeDao(IKundeDao kundeDao) {
		this.kundeDao = kundeDao;
	}

	@Override
	public List<Kunde> getKundeWithKartentechnologien() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Kunde> getKundeWithSeriennummern() {
		// TODO Auto-generated method stub
		return null;
	}

}
