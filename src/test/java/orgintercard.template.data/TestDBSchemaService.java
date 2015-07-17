package org.intercard.template.data;

import java.util.List;

import org.intercard.template.data.db.dao.IClassicDao;
import org.intercard.template.data.db.dao.IDesfireDao;
import org.intercard.template.data.db.dao.IKartenTechnologienDao;
import org.intercard.template.data.db.dao.IKundeDao;
import org.intercard.template.data.db.dao.ILegicDao;
import org.intercard.template.data.db.dao.ISerienNummerDao;
import org.intercard.template.data.db.dao.IVerbundDao;
import org.intercard.template.data.db.dao.IVerbundschluesselDao;
import org.intercard.template.data.db.domain.Classic;
import org.intercard.template.data.db.domain.Desfire;
import org.intercard.template.data.db.domain.KartenTechnologien;
import org.intercard.template.data.db.domain.Kunde;
import org.intercard.template.data.db.domain.Legic;
import org.intercard.template.data.db.domain.SerienNummer;
import org.intercard.template.data.db.domain.Verbund;
import org.intercard.template.data.db.domain.Verbundschluessel;
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

	IDesfireDao desfireDao = (IDesfireDao) context
			.getBean("org.intercard.template.data.db.dao.IDesfireDao");

	ILegicDao legicDao = (ILegicDao) context
			.getBean("org.intercard.template.data.db.dao.ILegicDao");

	ISerienNummerDao seriennummerDao = (ISerienNummerDao) context
			.getBean("org.intercard.template.data.db.dao.ISerienNummerDao");

	IVerbundschluesselDao verbundschluesselDao = (IVerbundschluesselDao) context
			.getBean("org.intercard.template.data.db.dao.IVerbundschluesselDao");

	IKartenTechnologienDao kartentechnologienDao = (IKartenTechnologienDao) context
			.getBean("org.intercard.template.data.db.dao.IKartenTechnologienDao");

	public void test() {

		try {

			Kunde kunde = kundeDao.findbyName("Freiburg Uni");
			if (kunde == null)
				fail();

			logger.debug("----------------------------------------------------------------------------------------");

			logger.debug(kunde.toString());
			System.out.println(kunde);
			logger.debug("----------------------------------------------------------------------------------------");

		} catch (Exception e) {
			logger.error("Exception", e);
			fail(e.toString());
		}

		try {

			Kunde kunde = kundeDao.findbyName("Tübingen-Hohenheim STW");
			if (kunde == null)
				fail();

			logger.debug("----------------------------------------------------------------------------------------");

			logger.debug(kunde.toString());
			System.out.println(kunde);
			logger.debug("----------------------------------------------------------------------------------------");

		} catch (Exception e) {
			logger.error("Exception", e);
			fail(e.toString());
		}

		try {

			Kunde kundeeins = kundeDao.findbyName("Trossingen MH");
			if (kundeeins == null)
				fail();

			logger.debug("----------------------------------------------------------------------------------------");

			logger.debug(kundeeins.toString());
			logger.debug("----------------------------------------------------------------------------------------");

		} catch (Exception e) {
			logger.error("Exception", e);
			fail(e.toString());
		}

		try {

			Classic classickarte = classicDao.findActivClassic(true);
			if (classickarte == null)
				fail();

			logger.debug("----------------------------------------------------------------------------------------");

			logger.debug(classickarte.toString());
			logger.debug("-----------------------------------");
			logger.debug(classickarte.toStringZusammengesetzt());
			logger.debug("----------------------------------------------------------------------------------------");

		} catch (Exception e) {
			logger.error("Exception", e);
			fail(e.toString());
		}

		try {

			List<SerienNummer> seriennummer = seriennummerDao
					.findAllSeriennummern();
			if (seriennummer == null)
				fail();

			logger.debug("----------------------------------------------------------------------------------------");

			logger.debug(seriennummer.toString());

			logger.debug("----------------------------------------------------------------------------------------");

		} catch (Exception e) {
			logger.error("Exception", e);
			fail(e.toString());
		}

		try {

			List<KartenTechnologien> kartentechnologie = kartentechnologienDao
					.findKartentechnologien();
			if (kartentechnologie == null)
				fail();

			logger.debug("----------------------------------------------------------------------------------------");

			logger.debug(kartentechnologie.toString());

			logger.debug("----------------------------------------------------------------------------------------");

		} catch (Exception e) {
			logger.error("Exception", e);
			fail(e.toString());
		}

	}

	@Override
	protected void setUp() throws Exception {

		// Create Verbund

		// Verbund verbund = new Verbund();
		// verbund.setVerbundname("Tübingen-Hohenheim");
		// List<Kunde> verbundsTeilnehmer = verbund.getVerbundsTeilnehmer();
		// verbundsTeilnehmer.add(element);
		// verbund.setVerbundsTeilnehmer(verbundsTeilnehmer);
		// System.out.println(verbundsTeilnehmer);
		// verbundDao.doSave(verbund);

		Verbund verbund = new Verbund();
		verbund.setVerbundname("Tübingen-Hohenheim");
		verbundDao.doSave(verbund);

		Verbund neuerverbund = new Verbund();
		neuerverbund.setVerbundname("Freiburg");
		verbundDao.doSave(neuerverbund);

		/* Create SerienNummer */
		SerienNummer nummer = new SerienNummer();
		nummer.setSnanfang(15000);
		nummer.setSnende(15999);
		nummer.setKommentar(null);
		nummer.setVergebenam(null);
		nummer.setAnzahl(999);

		seriennummerDao.doSave(nummer);

		SerienNummer neuenummer = new SerienNummer();
		neuenummer.setSnanfang(10000);
		neuenummer.setSnende(10999);
		neuenummer.setKommentar("Hallo");
		neuenummer.setVergebenam(null);// //////////////////////////////////////////
		neuenummer.setAnzahl(999);

		SerienNummer neueneuenummer = new SerienNummer();
		neueneuenummer.setSnanfang(500);
		neueneuenummer.setSnende(1000);
		neueneuenummer.setKommentar("Ganz neu");
		neueneuenummer.setVergebenam(null);// //////////////////////////////////////////
		neueneuenummer.setAnzahl(500);

		seriennummerDao.doSave(neuenummer);

		/* Create KartenTechnologien */
		Classic karteclassic = new Classic();
		karteclassic.setAktiv(true);
		karteclassic.setKeyfilepath("Reutlingen_HS_ICS.c3P1");
		karteclassic.setType(Aufbautype.mad);
		karteclassic.setN1V(8);
		karteclassic.setN1A(102);
		karteclassic.setN2(17);
		karteclassic.setN3(10);
		karteclassic.toStringZusammengesetzt();
		classicDao.doSave(karteclassic);

		Desfire kartedesfire = new Desfire();
		kartedesfire.setAktiv(true);
		kartedesfire.setKeyfilepath("Trossingen_HfM_ICS.c3P1");
		kartedesfire.setN1V(4);
		kartedesfire.setN1A(102);
		kartedesfire.setN2(17);
		kartedesfire.setN3(7);
		kartedesfire.setAufbaustruktur("IC-Standard/DESFire");
		kartedesfire.setMinorversion(null);
		desfireDao.doSave(kartedesfire);

		Legic kartelegic = new Legic();
		kartelegic.setAktiv(true);
		kartelegic.setKeyfilepath(null);
		kartelegic.setN1V(8);
		kartelegic.setN1A(105);
		kartelegic.setN2(19);
		kartelegic.setN3(1);
		legicDao.doSave(kartelegic);

		// Create Kunden
		Kunde element = new Kunde();
		element.setKundenname("Trossingen MH");
		element.setSapkundennr("1234");
		element.setSapstatus("1");
		element.setHochschulregionnummer("08-06");
		element.setHochschulnummer("2700");
		element.setFremdsysnr(null);
		element.setLaenderkuerzel(Laenderkuerzel.DE);
		element.setVerbund(verbund);

		Kunde glement = new Kunde();
		glement.setKundenname("Tübingen-Hohenheim STW");
		glement.setSapkundennr("3585");
		glement.setSapstatus("1");
		glement.setHochschulregionnummer("08-06");
		glement.setHochschulnummer(null);
		glement.setFremdsysnr(null);
		glement.setLaenderkuerzel(Laenderkuerzel.DE);
		glement.setVerbundsmutter(true);
		glement.setVerbund(verbund);

		Kunde flement = new Kunde();
		flement.setKundenname("Freiburg Uni");
		flement.setSapkundennr("2345");
		flement.setSapstatus("1");
		flement.setHochschulregionnummer("08-01");
		flement.setHochschulnummer("1241");
		flement.setFremdsysnr("30.30.1.89");
		flement.setLaenderkuerzel(Laenderkuerzel.DE);
		flement.setVerbund(neuerverbund);//

		kundeDao.doSave(flement);
		kundeDao.doSave(element);
		kundeDao.doSave(glement);

		/**
		 * dem Kunde wird durch die Methode setVerbund ein Objekt verbund mit
		 * dem Datentyp Verbund übergeben
		 */
		nummer.setKunde(element);
		neuenummer.setKunde(flement);
		neueneuenummer.setKunde(glement);
		kundeDao.doUpdate(flement);
		kundeDao.doUpdate(element);
		kundeDao.doUpdate(glement);

		seriennummerDao.doUpdate(neueneuenummer);
		seriennummerDao.doUpdate(neuenummer);
		seriennummerDao.doUpdate(nummer);

		/* Create Verbundschluessel */
		Verbundschluessel schluessel = new Verbundschluessel();
		schluessel.setBibliotheksnr(true);
		schluessel.setHauptboerse(false);
		schluessel.setMtknr_trw_daten(true);
		schluessel.setOeffenDaten(false);
		schluessel.setZutrittsnr(false);
		schluessel.setKunde(element);
		verbundschluesselDao.doSave(schluessel);

		Verbundschluessel neuschluessel = new Verbundschluessel();
		neuschluessel.setBibliotheksnr(true);
		neuschluessel.setHauptboerse(false);
		neuschluessel.setMtknr_trw_daten(true);
		neuschluessel.setOeffenDaten(false);
		neuschluessel.setZutrittsnr(false);
		neuschluessel.setKunde(flement);
		verbundschluesselDao.doSave(neuschluessel);

		Verbundschluessel neuneuschluessel = new Verbundschluessel();
		neuneuschluessel.setBibliotheksnr(true);
		neuneuschluessel.setHauptboerse(false);
		neuneuschluessel.setMtknr_trw_daten(true);
		neuneuschluessel.setOeffenDaten(false);
		neuneuschluessel.setZutrittsnr(false);
		neuneuschluessel.setKunde(glement);
		verbundschluesselDao.doSave(neuneuschluessel);

		/* Ende Create Verbundschluessel */

		/* dem Kunde eine Kartentechnologie zuweisen */
		kartedesfire.setKunde(glement);
		karteclassic.setKunde(element);
		kartedesfire.setKunde(element);
		kartelegic.setKunde(flement);
		classicDao.doUpdate(karteclassic);
		desfireDao.doUpdate(kartedesfire);
		legicDao.doUpdate(kartelegic);

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
