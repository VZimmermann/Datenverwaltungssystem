package org.intercard.template.data;

import org.intercard.template.data.db.dao.IClassicDao;
import org.intercard.template.data.db.dao.IKundeDao;
import org.intercard.template.data.db.dao.IVerbundDao;
import org.intercard.template.data.db.domain.Classic;
import org.intercard.template.data.db.domain.Kunde;
import org.intercard.template.data.db.domain.Verbund;
import org.intercard.template.data.db.domain.enums.Aufbautype;
import org.intercard.template.data.db.domain.enums.Laenderkuerzel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDBSchemaService extends org.intercard.template.SpringTestBase {

	private static final Logger logger = LoggerFactory
			.getLogger(TestDBSchemaService.class);

	IKundeDao kundeDao = (IKundeDao) context
			.getBean("org.intercard.template.data.db.dao.IKundeDao");

	IVerbundDao verbundDao = (IVerbundDao) context
			.getBean("org.intercard.template.data.db.dao.IVerbundDao");

	IClassicDao classicDao = (IClassicDao) context
			.getBean("org.intercard.template.data.db.dao.IClassicDao");

	public void test() {

		try {

			Kunde kunde = kundeDao.findbyName("Reiner");
			if (kunde == null)
				fail();

			logger.debug("----------------------------------------------------------------------------------------");

			logger.debug(kunde.toString());
			logger.debug("----------------------------------------------------------------------------------------");

		} catch (Exception e) {
			logger.error("Exception", e);
			fail(e.toString());
		}

		try {

			Kunde kundeeins = kundeDao.findbyName("Maier");
			if (kundeeins == null)
				fail();

			logger.debug("----------------------------------------------------------------------------------------");

			logger.debug(kundeeins.toString());
			logger.debug("----------------------------------------------------------------------------------------");

		} catch (Exception e) {
			logger.error("Exception", e);
			fail(e.toString());
		}

	}

	@Override
	protected void setUp() throws Exception {

		// Create Verbund
		Verbund verbund = new Verbund();
		verbund.setVerbundname("Tübingen-Hohenheim");
		verbundDao.doSave(verbund);

		// Create Kunde
		Kunde element = new Kunde();
		element.setKundenname("Reiner");
		element.setSapkundennr("1234");
		element.setSapstatus("status");
		element.setHochschulregionnummer("08/04");
		element.setHochschulnummer("6574");
		element.setFremdsysnr("8798");
		element.setLaenderkuerzel(Laenderkuerzel.DE);
		element.setVerbundsmutter(true);
		element.setVerbund(verbund);
		/**
		 * dem Kunde wird durch die Methode setVerbund ein Objekt verbund mit
		 * dem Datentyp Verbund übergeben
		 */

		kundeDao.doSave(element);

		Kunde flement = new Kunde();
		flement.setKundenname("Maier");
		flement.setSapkundennr("2345");
		flement.setSapstatus("status");
		flement.setHochschulregionnummer("08/04");
		flement.setHochschulnummer("9875");
		flement.setFremdsysnr(null);
		flement.setLaenderkuerzel(Laenderkuerzel.DE);

		kundeDao.doSave(flement);

		flement.setVerbund(verbund);

		kundeDao.doUpdate(flement);

		// Create Verbund
		// Verbund verbund = new Verbund();
		// verbund.setVerbundname("Tübingen-Hohenheim");
		// List<Kunde> verbundsTeilnehmer = verbund.getVerbundsTeilnehmer();
		// verbundsTeilnehmer.add(element);
		// verbund.setVerbundsTeilnehmer(verbundsTeilnehmer);
		// System.out.println(verbundsTeilnehmer);
		// verbundDao.doSave(verbund);

		/** Create KartenTechnologie */
		Classic karte = new Classic();
		karte.setAktiv(true);
		karte.setKeyfilepath("Reutlingen_HS_ICS.c3P1");
		karte.setType(Aufbautype.mad);
		karte.setN1V(8);
		karte.setN1A(102);
		karte.setN2(17);
		karte.setN3(10);
		karte.setKunde(element);
		classicDao.doSave(karte);

		super.setUp();
	}
	// @Override
	// protected void tearDown() throws Exception {
	//
	// for (Kunde kunde : kundeDao.findAll()) {
	// kundeDao.doDelete(kunde);
	// }
	// super.tearDown();
	// }
}
