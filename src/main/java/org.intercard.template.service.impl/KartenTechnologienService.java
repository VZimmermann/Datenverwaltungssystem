package org.intercard.template.service.impl;

import java.util.List;

import org.intercard.template.data.db.dao.IClassicDao;
import org.intercard.template.data.db.dao.IDesfireDao;
import org.intercard.template.data.db.dao.IKartenTechnologienDao;
import org.intercard.template.data.db.dao.ILegicDao;
import org.intercard.template.data.db.domain.Classic;
import org.intercard.template.data.db.domain.Desfire;
import org.intercard.template.data.db.domain.KartenTechnologien;
import org.intercard.template.data.db.domain.Legic;
import org.intercard.template.data.db.domain.enums.Aufbautype;
import org.intercard.template.data.db.ex.DataException;
import org.intercard.template.service.IKartenTechnologienService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KartenTechnologienService implements IKartenTechnologienService {

	private static final Logger logger = LoggerFactory
			.getLogger(KartenTechnologienService.class);

	private IKartenTechnologienDao kartentechnologienDao;
	private IDesfireDao desfireDao;
	private IClassicDao classicDao;
	private ILegicDao legicDao;

	@Override
	public boolean createDesfire(Desfire desfire) {
		if (desfire != null) {
			try {
				desfireDao.doSave(desfire);
				logger.debug(" Service Create Desfire");
				return true;
			} catch (DataException e) {
				logger.debug("EX", e);
			}
		}
		return false;

	}

	@Override
	public boolean updateDesfire(Desfire desfire) {
		if (desfire != null && desfire.getId() != 0) {
			try {
				desfireDao.doUpdate(desfire);
				logger.debug(" Service Update Desfire");
				return true;
			} catch (DataException e) {
				logger.debug("EX", e);
			}
		}
		return false;

	}

	@Override
	public boolean deleteDesfire(Desfire desfire) {
		if (desfire != null && desfire.getId() != 0) {
			try {
				desfireDao.doDelete(desfire);
				logger.debug(" Service Delete Desfire");
				return true;
			} catch (DataException e) {
				logger.debug("EX", e);
			}
		}
		return false;
	}

	@Override
	public boolean createClassic(Classic classic) {
		if (classic != null) {
			try {
				classicDao.doSave(classic);
				logger.debug(" Service Create Classic");
				return true;
			} catch (DataException e) {
				logger.debug("EX", e);
			}
		}
		return false;

	}

	@Override
	public boolean updateClassic(Classic classic) {
		if (classic != null && classic.getId() != 0) {
			try {
				classicDao.doUpdate(classic);
				logger.debug(" Service Update Classic");
				return true;
			} catch (DataException e) {
				logger.debug("EX", e);
			}
		}
		return false;
	}

	@Override
	public boolean deleteClassic(Classic classic) {
		if (classic != null && classic.getId() != 0) {
			try {
				classicDao.doDelete(classic);
				logger.debug(" Service Delete Classic");
				return true;
			} catch (DataException e) {
				logger.debug("EX", e);
			}
		}
		return false;
	}

	@Override
	public boolean createLegic(Legic legic) {
		if (legic != null) {
			try {
				legicDao.doSave(legic);
				logger.debug(" Service Create Legic");
				return true;
			} catch (DataException e) {
				logger.debug("EX", e);
			}
		}
		return false;
	}

	@Override
	public boolean updateLegic(Legic legic) {
		if (legic != null && legic.getId() != 0) {
			try {
				legicDao.doUpdate(legic);
				logger.debug(" Service Update Legic");
				return true;
			} catch (DataException e) {
				logger.debug("EX", e);
			}
		}
		return false;
	}

	@Override
	public boolean deleteLegic(Legic legic) {
		if (legic != null && legic.getId() != 0) {
			try {
				legicDao.doDelete(legic);
				logger.debug(" Service Delete Legic");
				return true;
			} catch (DataException e) {
				logger.debug("EX", e);
			}
		}
		return false;
	}

	@Override
	public List<KartenTechnologien> getKartentechnologienList() {
		try {
			List<KartenTechnologien> ret = kartentechnologienDao.findAll();
			if (ret != null && !ret.isEmpty())
				return ret;
		} catch (DataException e) {
			logger.debug("EX", e);
		}
		return null;
	}

	//
	// @Override
	// public List<Aufbautype> getAufbautypeList() {
	// List<Aufbautype> auf = classicDao.findAll();
	// if (auf!= null && !auf.isEmpty())
	// return auf;
	// }
	// catch (DataException e) {
	// logger.debug("EX", e);
	// }
	// return null;
	// }

	@Override
	public boolean getAufbaustruktur(Desfire aufbaustruktur) {

		return false;
	}

	@Override
	public boolean getMinorversion(Desfire minorversion) {

		return false;
	}

	@Override
	public boolean getAufbautype(Classic aufbautype) {

		return false;
	}

	@Override
	public KartenTechnologien getKartenTechnologien(int id) {

		return null;
	}

	@Override
	public List<Aufbautype> getAufbautypeList() {

		return null;
	}

	/*
	 * SETTER FOR SPRING CONFIG
	 */

	public void setKartentechnologienDao(
			IKartenTechnologienDao kartentechnologienDao) {
		this.kartentechnologienDao = kartentechnologienDao;
	}

}
