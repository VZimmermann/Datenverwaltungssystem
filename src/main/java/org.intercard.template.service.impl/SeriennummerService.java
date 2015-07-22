package org.intercard.template.service.impl;

import java.util.Date;
import java.util.List;

import org.intercard.template.data.db.dao.ISerienNummerDao;
import org.intercard.template.data.db.domain.SerienNummer;
import org.intercard.template.data.db.ex.DataException;
import org.intercard.template.service.ISeriennummerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeriennummerService implements ISeriennummerService {

	private static final Logger logger = LoggerFactory
			.getLogger(SeriennummerService.class);

	private ISerienNummerDao seriennummerDao;

	@Override
	public Long nextfreeSerienNummer(SerienNummer seriennummer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long lastSerienNummer(SerienNummer seriennummer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long defineSeriennummernrange(SerienNummer anzahl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean reserveSeriennummernrange(SerienNummer seriennummer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SerienNummer> getSeriennummernrangeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteSerienNummern(SerienNummer seriennummer) {
		if (seriennummer != null && seriennummer.getSnanfang() != 0) {
			try {
				seriennummerDao.doDelete(seriennummer);
				logger.debug(" Service Delete Seriennummer");
				return true;
			} catch (DataException e) {
				logger.debug("EX", e);
			}
		}
		return false;
	}

	@Override
	public SerienNummer getSerienNummeranfang(int snanfang) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SerienNummer getSerienNummerende(int snende) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SerienNummer getKommentar(String kommentar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SerienNummer getVergebenam(Date vergeben) {
		// TODO Auto-generated method stub
		return null;
	}

}
