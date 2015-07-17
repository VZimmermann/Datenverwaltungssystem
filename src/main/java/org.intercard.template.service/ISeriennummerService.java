package org.intercard.template.service;

import java.util.Date;
import java.util.List;

import org.intercard.template.data.db.domain.SerienNummer;

public interface ISeriennummerService {

	// nächste freie Seriennummer berechen
	public int nextfreeSerienNummer(SerienNummer seriennummer);

	// letzte vergebene Seriennummer berechnen
	public int lastSerienNummer(SerienNummer seriennummer);

	// Sereinnummernrange vergeben-->anzahl
	public int defineSeriennummernrange(SerienNummer anzahl);

	// Seriennummernrange reservieren
	public boolean reserveSeriennummernrange(SerienNummer seriennummer);

	// Seriennummerbereich ausgeben
	public List<SerienNummer> getSeriennummernrangeList();

	// Seriennummernbereich als wieder frei kennzeichnen
	public boolean deleteSerienNummern(SerienNummer seriennummer);

	public SerienNummer getSerienNummeranfang(int snanfang);

	public SerienNummer getSerienNummerende(int snende);

	public SerienNummer getKommentar(String kommentar);

	public SerienNummer getVergebenam(Date vergeben);

}
