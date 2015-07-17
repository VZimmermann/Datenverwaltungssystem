package org.intercard.template.data.db.dao;

import java.util.List;

import org.intercard.template.data.db.domain.SerienNummer;
import org.intercard.template.data.db.ex.DataException;

public interface ISerienNummerDao extends IDao<SerienNummer> {

	/** Find all Seriennummern */
	public List<SerienNummer> findAllSeriennummern() throws DataException;

	/**
	 * Find Seriennummernbereiche (Ranges)-->Wenn man die erste Nummer hat wird
	 * die Anzahl angezeigt
	 */

	public SerienNummer findSeriennummeranfang(int snanfang)
			throws DataException;

}
