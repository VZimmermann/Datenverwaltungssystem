package org.intercard.template.service.impl;

import java.util.List;

import org.intercard.template.data.db.dao.IVerbundDao;
import org.intercard.template.data.db.domain.Kunde;
import org.intercard.template.data.db.domain.Verbund;
import org.intercard.template.service.IVerbundService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerbundService implements IVerbundService {

	private static final Logger logger = LoggerFactory
			.getLogger(VerbundService.class);

	private IVerbundDao verbundDao;

	@Override
	public List<Verbund> getVerbundList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createVerbund(Verbund verbund) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateVerbund(Verbund verbund) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteVerbund(Verbund verbund) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Verbund> getVerbundschluesselList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Verbund getVerbund(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Verbund getVerbund(String verbundname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Verbund> searchVerbund(String verbund) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Kunde> getVerbundsTeilnehmer(Verbund verbund) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * SETTER FOR SPRING CONFIG
	 */
	public void setVerbundDao(IVerbundDao verbundDao) {
		this.verbundDao = verbundDao;
	}

}
