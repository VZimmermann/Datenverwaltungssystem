package org.intercard.template.service.impl;

import java.util.List;

import org.intercard.template.data.db.dao.IVerbundDao;
import org.intercard.template.data.db.domain.Verbund;
import org.intercard.template.data.db.ex.DataException;
import org.intercard.template.service.IVerbundService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerbundService implements IVerbundService {

	private static final Logger logger = LoggerFactory
			.getLogger(VerbundService.class);

	private IVerbundDao verbundDao;

	/** get a List with all excisting Verbünde */
	@Override
	public List<Verbund> getVerbundList() {
		try {
			List<Verbund> verbundlist = verbundDao.findAllVerbund();
			if (verbundlist != null && !verbundlist.isEmpty())
				return verbundlist;
		} catch (DataException e) {
			logger.debug("Keine Ergenisse");
		}
		return null;
	}

	/** get a Verbund by searching for a name */
	@Override
	public Verbund getVerbund(String name) {
		if (name != null) {
			try {
				Verbund verbund = verbundDao.findVerbund(name);
				return verbund;
			} catch (DataException e) {
				logger.debug("Kein Verbund gefunden");
			}
		}
		return null;
	}

	/** get a Verbund by searching for an id */
	@Override
	public Verbund getVerbund(int id) {
		if (id != 0) {
			try {
				Verbund verbund = verbundDao.findOne(id);
				return verbund;
			} catch (DataException e) {
				logger.debug("Kein Verbund gefunden");
			}
		}
		return null;
	}

	/** Create a new Verbund */
	@Override
	public Verbund createVerbund(Verbund verbund) {
		if (verbund != null) {
			try {
				verbundDao.doSave(verbund);
				logger.debug("Service Create Verbund");
				return verbund;
			} catch (DataException e) {
				logger.debug("Konnte nicht erstellt werden", e);
			}
		}
		return null;

	}

	/** Update an excisting Verbund */
	@Override
	public Verbund updateVerbund(Verbund verbund) {
		if (verbund != null && verbund.getId() != 0) {
			try {
				verbundDao.doUpdate(verbund);
				logger.debug("Service Update Verbund");
				return verbund;
			} catch (DataException e) {
				logger.debug("Konnte nicht upgedated werden", e);
			}
		}
		return null;

	}

	/** Delete an excisting Verbund */
	@Override
	public Verbund deleteVerbund(Verbund verbund) {
		if (verbund != null && verbund.getId() != 0) {
			try {
				verbundDao.doDelete(verbund);
				logger.debug("Service Delete Verbund");
				return verbund;
			} catch (DataException e) {
				logger.debug("Konnte nicht gelöscht werden");
			}
		}
		return null;
	}

	public IVerbundDao getVerbundDao() {
		return verbundDao;
	}

	public void setVerbundDao(IVerbundDao verbundDao) {
		this.verbundDao = verbundDao;
	}

}
