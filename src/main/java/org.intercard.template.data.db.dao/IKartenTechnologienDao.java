package org.intercard.template.data.db.dao;

import java.util.List;

import org.intercard.template.data.db.domain.KartenTechnologien;
import org.intercard.template.data.db.ex.DataException;

public interface IKartenTechnologienDao extends IDao<KartenTechnologien> {

	/** find all existing CardTechnologies with type KartenTechnologie */
	public List<KartenTechnologien> findKartentechnologien()
			throws DataException;

}
