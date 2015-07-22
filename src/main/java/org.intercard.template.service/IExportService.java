package org.intercard.template.service;

import org.intercard.template.data.db.domain.Kunde;

public interface IExportService {

	// Exportpfad erzeugen-->Sysnr_Export_SAPNrxxx
	public String createExportpfad();

	// SAPnummer auslesen
	public boolean getSAPnr(Kunde sapnummer);
}
