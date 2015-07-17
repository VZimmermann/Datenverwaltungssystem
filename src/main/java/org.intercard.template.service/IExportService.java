package org.intercard.template.service;

import org.intercard.template.data.db.domain.Classic;
import org.intercard.template.data.db.domain.Desfire;
import org.intercard.template.data.db.domain.Kunde;
import org.intercard.template.data.db.domain.Legic;

public interface IExportService {
	// Daten bei der Auswahl für den Export übernehmen
	// ?????

	// Exportpfad erzeugen-->Sysnr_Export_SAPNrxxx
	public String createExportpfad();

	// Systemnummer auslesen
	// brauch ich das hier überhaupt wenn ich das unter SystemNummernService
	// schon hab

	public int getSystemnummer(Classic systemnummer);

	public int getSystemnummer(Legic systemnummer);

	public int getSystemnummer(Desfire systemnummer);

	// SAPnummer auslesen
	public boolean getSAPnr(Kunde sapnummer);
}
