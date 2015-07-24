package org.intercard.template.service;

import java.util.List;

import org.intercard.template.data.db.domain.Kunde;
import org.intercard.template.data.db.domain.SerienNummer;

public interface ISeriennummerService {

	/** reserve a Range for a Kunde */
	public SerienNummer reserveSeriennummernRange(Kunde kunde, int anzahl,
			int snanfang);

	/** get a List of Seriennummern */
	public List<SerienNummer> getSeriennummernList();

	/** Delete a Range */
	public boolean deleteSeriennummern(SerienNummer seriennummer);

	/** get a Seriennummer by its beginning */
	public SerienNummer getSeriennummer(int snanfang);

}
