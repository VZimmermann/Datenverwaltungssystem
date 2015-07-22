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

	public boolean updateLegic(Legic legic);

	public boolean deleteLegic(Legic legic);

	public List<KartenTechnologien> getKartentechnologienList();

	public KartenTechnologien getKartenTechnologien(int id);

	// KArtentechnologie Kunde zuordnen

	// Kartenlayout auslesen und anzeigen

	public List<Aufbautype> getAufbautypeList();// nur bei Classic

	public boolean getAufbaustruktur(Desfire aufbaustruktur);

	public boolean getMinorversion(Desfire minorversion);

	public boolean getAufbautype(Classic aufbautype);

}
