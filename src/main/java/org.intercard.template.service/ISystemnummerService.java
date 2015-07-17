package org.intercard.template.service;

import org.intercard.template.data.db.domain.Classic;
import org.intercard.template.data.db.domain.Desfire;
import org.intercard.template.data.db.domain.Legic;

public interface ISystemnummerService {

	// Systemnummer suchen

	public boolean searchSystemnummer(Classic systemnummer);

	public boolean searchSystemnummer(Legic systemnummer);

	public boolean searchSystemnummer(Desfire systemnummer);

	// Systemnummer zusammensetzen aus den Objekten der Kartentechnologien
	public String constructSeriennummer();

	// nächste freie Systemnummer berechnen
	public boolean nextfreeSystemnummer(Classic systemnummer);

	public boolean nextfreeSystemnummer(Legic systemnummer);

	public boolean nextfreeSystemnummer(Desfire systemnummer);

	// Systemnummer als vergeben kennzeichnen

	// Systemnummer einem Kunde zu ordnen
	public boolean matchSystemnummer(Classic systemnummer);

	public boolean matchSystemnummer(Legic systemnummer);

	public boolean matchSystemnummer(Desfire systemnummer);

	// Systemnummer der Kartentechnologien
	public Classic getClassic(int sysnummerclassic);

	public Legic getLegic(int sysnummerlegic);

	public Desfire getDesfire(int sysnummerdesfire);

	/**
	 * die Systemnummer zusammensetzen wird durch die toStringzusammengesetzt()
	 * erledigt, die in den Klassen Desfire, Legic und Classic stehen
	 */
}
