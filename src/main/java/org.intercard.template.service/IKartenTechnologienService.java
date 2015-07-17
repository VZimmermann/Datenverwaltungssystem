package org.intercard.template.service;

import java.util.List;

import org.intercard.template.data.db.domain.Classic;
import org.intercard.template.data.db.domain.Desfire;
import org.intercard.template.data.db.domain.KartenTechnologien;
import org.intercard.template.data.db.domain.Legic;
import org.intercard.template.data.db.domain.enums.Aufbautype;

public interface IKartenTechnologienService {

	// Desfireinformationen auslesen
	public boolean createDesfire(Desfire desfire);

	public boolean updateDesfire(Desfire desfire);

	public boolean deleteDesfire(Desfire desfire);

	// Classicinformationen anlegen, aktualisieren, löschen

	public boolean createClassic(Classic classic);

	public boolean updateClassic(Classic classic);

	public boolean deleteClassic(Classic classic);

	// Legicinformationen anlegen, aktualisieren, löschen
	public boolean createLegic(Legic legic);

	public boolean updateClassic(Legic legic);

	public boolean deleteClassic(Legic legic);

	// neue Kartentechnologie anlegen, aktualisieren, löschen
	public boolean createKartentechnologie(KartenTechnologien kartentechnologie);

	public boolean updateKartentechnologie(KartenTechnologien kartentechnologie);

	public boolean deleteKartentechnologie(KartenTechnologien kartentechnologie);

	public KartenTechnologien getKartentechnologien(String name);

	public List<KartenTechnologien> getKartentechnologienList();

	public KartenTechnologien getKartenTechnologien(int id);

	// KArtentechnologie Kunde zuordnen

	// Kartenlayout auslesen und anzeigen

	public List<Aufbautype> getAufbautypeList();

	public boolean getAufbaustruktur(Desfire aufbaustruktur);

	public boolean getMinorversion(Desfire minorversion);

	public boolean getAufbautype(Classic aufbautype);
}
