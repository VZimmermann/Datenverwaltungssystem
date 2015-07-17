package org.intercard.template.service.impl;

import java.util.List;

import org.intercard.template.data.db.dao.IKartenTechnologienDao;
import org.intercard.template.data.db.domain.Classic;
import org.intercard.template.data.db.domain.Desfire;
import org.intercard.template.data.db.domain.KartenTechnologien;
import org.intercard.template.data.db.domain.Legic;
import org.intercard.template.data.db.domain.enums.Aufbautype;
import org.intercard.template.service.IKartenTechnologienService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KartenTechnologienService implements IKartenTechnologienService {

	private static final Logger logger = LoggerFactory
			.getLogger(KartenTechnologienService.class);

	private IKartenTechnologienDao kartentechnologienDao;

	@Override
	public boolean createKartentechnologie(KartenTechnologien kartentechnologie) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateKartentechnologie(KartenTechnologien kartentechnologie) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteKartentechnologie(KartenTechnologien kartentechnologie) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createDesfire(Desfire desfire) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDesfire(Desfire desfire) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDesfire(Desfire desfire) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createClassic(Classic classic) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateClassic(Classic classic) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteClassic(Classic classic) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createLegic(Legic legic) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateClassic(Legic legic) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteClassic(Legic legic) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public KartenTechnologien getKartentechnologien(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KartenTechnologien> getKartentechnologienList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KartenTechnologien getKartenTechnologien(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aufbautype> getAufbautypeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getAufbaustruktur(Desfire aufbaustruktur) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getMinorversion(Desfire minorversion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAufbautype(Classic aufbautype) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * SETTER FOR SPRING CONFIG
	 */

	public void setKartentechnologienDao(
			IKartenTechnologienDao kartentechnologienDao) {
		this.kartentechnologienDao = kartentechnologienDao;
	}

}
