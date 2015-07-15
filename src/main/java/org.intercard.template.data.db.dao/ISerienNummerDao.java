package org.intercard.template.data.db.dao;

import java.util.Date;
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
	public SerienNummer findSeriennummeranfang(Long snanfang)
			throws DataException;

	/** Find Seriennummern with a special date when they were created */
	public SerienNummer findSeriennummerbydate(Date date) throws DataException;

}
