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
import org.intercard.template.data.db.ex.DataException;
import org.intercard.template.data.domain.SystemNummer;
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

	/**
	 * public Classic nextfreeSystemnummerClassic(SystemNummer sysNum) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * 
	 * public Legic nextfreeSystemnummerLegic(SystemNummer sysNum) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * 
	 * public Desfire nextfreeSystemnummerDesfire(SystemNummer sysNum) { // TODO
	 * Auto-generated method stub return null; }
	 */

	/** Create, update, delete a Kartentechnologie with Type Desfire */
	@Override
	public Desfire createDesfire(Desfire desfire) {
		if (desfire != null) {
			try {
				desfireDao.doSave(desfire);
				logger.debug("Service Create Desfire");
				return desfire;
			} catch (DataException e) {
				logger.debug("Konnte nicht erstellt werden", e);
			}
		}
		return null;
	}

	@Override
	public Desfire updateDesfire(Desfire desfire) {
		if (desfire != null && desfire.getId() != 0) {
			try {
				desfireDao.doUpdate(desfire);
				logger.debug("Service Update Desfire");
				return desfire;
			} catch (DataException e) {
				logger.debug("Konnte nicht upgedated werden", e);
			}
		}
		return null;
	}

	@Override
	public Desfire deleteDesfire(Desfire desfire) {
		if (desfire != null && desfire.getId() != 0) {
			try {
				desfireDao.doDelete(desfire);
				logger.debug("Service Delete Desfire");
				return desfire;
			} catch (DataException e) {
				logger.debug("Konnte nicht gelöscht werden", e);
			}
		}
		return null;
	}

	/** Create, update, delete a Kartentechnologie with Type Classic */
	@Override
	public Classic createClassic(Classic classic) {
		if (classic != null) {
			try {
				classicDao.doSave(classic);
				logger.debug("Service Create Classic");
				return classic;
			} catch (DataException e) {
				logger.debug("Konnte nicht erstellt werden", e);
			}
		}
		return null;
	}

	@Override
	public Classic updateClassic(Classic classic) {
		if (classic != null && classic.getId() != 0) {
			try {
				classicDao.doUpdate(classic);
				logger.debug("Service Update Classic");
				return classic;
			} catch (DataException e) {
				logger.debug("Konnte nicht upgedated werden", e);
			}
		}
		return null;
	}

	@Override
	public Classic deleteClassic(Classic classic) {
		if (classic != null && classic.getId() != 0) {
			try {
				classicDao.doDelete(classic);
				logger.debug("Service Delete Classic");
				return classic;
			} catch (DataException e) {
				logger.debug("Konnte nicht gelöscht werden", e);
			}
		}
		return null;
	}

	/** Create, update, delete a Kartentechnologie with Type Legic */
	@Override
	public Legic createLegic(Legic legic) {
		if (legic != null) {
			try {
				legicDao.doSave(legic);
				logger.debug("Service Create Legic");
				return legic;
			} catch (DataException e) {
				logger.debug("Konnte nicht erstellt werden", e);
			}
		}
		return null;
	}

	@Override
	public Legic updateLegic(Legic legic) {
		if (legic != null && legic.getId() != 0) {
			try {
				legicDao.doUpdate(legic);
				logger.debug("Service Update Legic");
				return legic;
			} catch (DataException e) {
				logger.debug("Konnte nicht upgedated werden");
			}
		}
		return null;
	}

	@Override
	public Legic deleteLegic(Legic legic) {
		if (legic != null && legic.getId() != 0) {
			try {
				legicDao.doDelete(legic);
				logger.debug("Service Delete Legic");
				return legic;
			} catch (DataException e) {
				logger.debug("Konnte nicht gelöscht werden");
			}
		}
		return null;
	}

	/**
	 * nach einer Systemnummer suchen und wenn es diese in mehreren
	 * Kartentechnologien gibt ausgeben
	 */
	@Override
	public List<KartenTechnologien> getKartentechnologienList(
			SystemNummer systemnummer) {
		try {
			List<KartenTechnologien> kartentechnologien = kartentechnologienDao
					.findAllKartentechnologien();
			if (kartentechnologien != null && !kartentechnologien.isEmpty())
				return kartentechnologien;
		} catch (DataException e) {
			logger.debug("Keine Kartentechnologien vorhanden", e);
		}
		return null;
	}

	@Override
	public KartenTechnologien getKartenTechnologien(int id) {
		if (id != 0) {
			try {
				KartenTechnologien kartid = kartentechnologienDao.findOne(id);
				return kartid;
			} catch (DataException e) {
				logger.debug("Keine Ergebnisse", e);
			}
		}
		return null;
	}

	/** get only one Systemnummer */
	@Override
	public Classic searchClassicSystemnummer(SystemNummer systemnummer) {
		if (systemnummer != null) {
			/* ??????????????????????????????????????????????? */

		}
		return null;
	}

	@Override
	public Legic searchLegicSystemnummer(SystemNummer systemnummer) {

		return null;
	}

	@Override
	public Desfire searchDesfireSystemnummer(SystemNummer systemnummer) {

		return null;
	}

	public IKartenTechnologienDao getKartentechnologienDao() {
		return kartentechnologienDao;
	}

	public IDesfireDao getDesfireDao() {
		return desfireDao;
	}

	public IClassicDao getClassicDao() {
		return classicDao;
	}

	public ILegicDao getLegicDao() {
		return legicDao;
	}

	public void setKartentechnologienDao(
			IKartenTechnologienDao kartentechnologienDao) {
		this.kartentechnologienDao = kartentechnologienDao;
	}

	public void setDesfireDao(IDesfireDao desfireDao) {
		this.desfireDao = desfireDao;
	}

	public void setClassicDao(IClassicDao classicDao) {
		this.classicDao = classicDao;
	}

	public void setLegicDao(ILegicDao legicDao) {
		this.legicDao = legicDao;
	}

}
