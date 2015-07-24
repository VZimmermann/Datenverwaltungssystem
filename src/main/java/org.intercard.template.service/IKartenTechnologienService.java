package org.intercard.template.service;

import java.util.List;

import org.intercard.template.data.db.domain.Classic;
import org.intercard.template.data.db.domain.Desfire;
import org.intercard.template.data.db.domain.KartenTechnologien;
import org.intercard.template.data.db.domain.Legic;
import org.intercard.template.data.domain.SystemNummer;

public interface IKartenTechnologienService {

	/**
	 * public Classic nextfreeSystemnummerClassic(SystemNummer sysNum);
	 * 
	 * public Legic nextfreeSystemnummerLegic (SystemNummer sysNum);
	 * 
	 * public Desfire nextfreeSystemnummerDesfire (SystemNummer sysNum);
	 */

	/** Create, update, delete a Kartentechnologie with Type Desfire */
	public Desfire createDesfire(Desfire desfire);

	public Desfire updateDesfire(Desfire desfire);

	public Desfire deleteDesfire(Desfire desfire);

	/** Create, update, delete a Kartentechnologie with Type Classic */

	public Classic createClassic(Classic classic);

	public Classic updateClassic(Classic classic);

	public Classic deleteClassic(Classic classic);

	/** Create, update, delete a Kartentechnologie with Type Legic */
	public Legic createLegic(Legic legic);

	public Legic updateLegic(Legic legic);

	public Legic deleteLegic(Legic legic);

	/**
	 * nach einer Systemnummer suchen und wenn es diese in mehreren
	 * Kartentechnologien gibt ausgeben
	 */
	public List<KartenTechnologien> getKartentechnologienList(
			SystemNummer systemnummer);

	public KartenTechnologien getKartenTechnologien(int id);

	/** get only one Systemnummer */

	public Classic searchClassicSystemnummer(SystemNummer systemnummer);

	public Legic searchLegicSystemnummer(SystemNummer systemnummer);

	public Desfire searchDesfireSystemnummer(SystemNummer systemnummer);

	/*
	 * 
	 * Pruefen ob benoetigt wird!!!!!! // Systemnummer einem Kunde zu ordnen
	 * public boolean addSystemnummer(Classic systemnummer, Kunde kunde);
	 * 
	 * public boolean addSystemnummer(Legic systemnummer, Kunde kunde);
	 * 
	 * public boolean addSystemnummer(Desfire systemnummer, Kunde kunde);
	 */

}
