package org.intercard.template.service.impl;

import org.intercard.template.data.db.dao.IClassicDao;
import org.intercard.template.data.db.dao.IDesfireDao;
import org.intercard.template.data.db.dao.ILegicDao;
import org.intercard.template.data.db.domain.Classic;
import org.intercard.template.data.db.domain.Desfire;
import org.intercard.template.data.db.domain.Legic;
import org.intercard.template.service.ISystemnummerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemnummerService implements ISystemnummerService {

	private static final Logger logger = LoggerFactory
			.getLogger(SystemnummerService.class);

	private IClassicDao classicDao;
	private IDesfireDao desfireDao;
	private ILegicDao legicDao;

	@Override
	public String constructSeriennummer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean searchSystemnummer(Classic systemnummer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean searchSystemnummer(Legic systemnummer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean searchSystemnummer(Desfire systemnummer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean nextfreeSystemnummer(Classic systemnummer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean nextfreeSystemnummer(Legic systemnummer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean nextfreeSystemnummer(Desfire systemnummer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean matchSystemnummer(Classic systemnummer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean matchSystemnummer(Legic systemnummer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean matchSystemnummer(Desfire systemnummer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Classic getClassic(int sysnummerclassic) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Legic getLegic(int sysnummerlegic) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Desfire getDesfire(int sysnummerdesfire) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * SETTER FOR SPRING CONFIG
	 */
	public void setClassicDao(IClassicDao classicDao) {
		this.classicDao = classicDao;
	}

	public void setDesfireDao(IDesfireDao desfireDao) {
		this.desfireDao = desfireDao;
	}

	public void setLegicDao(ILegicDao legicDao) {
		this.legicDao = legicDao;
	}

}
