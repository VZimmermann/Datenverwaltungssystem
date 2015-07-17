package org.intercard.template.data.db.dao;

import java.util.List;

import org.intercard.template.data.db.domain.Kunde;
import org.intercard.template.data.db.ex.DataException;

public interface IKundeDao extends IDao<Kunde> {

	/** find all Clients by Name */
	public Kunde findbyName(String tName) throws DataException;

	/**
	 * Kunde joinen with KartenTechnologien, find Kunde with its
	 * Cardtechnologies
	 */
	public Kunde findWithBags(int id) throws DataException;

	public List<Kunde> findAllWithBags() throws DataException;

	/** Find a client and his Seriennummern */
	public Kunde findWithSeriennummern(int id) throws DataException;

	/** Find a client and his Verbundschluessel */
	public Kunde findWithVerbundschluessel(int id) throws DataException;

}
