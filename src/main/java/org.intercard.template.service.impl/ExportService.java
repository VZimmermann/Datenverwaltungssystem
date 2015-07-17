package org.intercard.template.service.impl;

import org.intercard.template.data.db.domain.Classic;
import org.intercard.template.data.db.domain.Desfire;
import org.intercard.template.data.db.domain.Kunde;
import org.intercard.template.data.db.domain.Legic;
import org.intercard.template.service.IExportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExportService implements IExportService {

	private static final Logger logger = LoggerFactory
			.getLogger(ExportService.class);

	@Override
	public String createExportpfad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSystemnummer(Classic systemnummer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSystemnummer(Legic systemnummer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSystemnummer(Desfire systemnummer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getSAPnr(Kunde sapnummer) {
		// TODO Auto-generated method stub
		return false;
	}

}
