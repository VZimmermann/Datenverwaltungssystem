package org.intercard.template.data.db.dao.impl;

import org.intercard.template.data.db.dao.IVerbundschluesselDao;
import org.intercard.template.data.db.domain.Verbundschluessel;

public class VerbundschluesselDao extends AbstractDao<Verbundschluessel>
		implements IVerbundschluesselDao {

	@Override
	protected Class<Verbundschluessel> getDomainClass() {
		return Verbundschluessel.class;
	}

	// @SuppressWarnings("unchecked")
	// @Override
	// public List<Verbundschluessel> findSchluesseltoKunde() throws
	// DataException {
	// Query q = entityManager.createNamedQuery("findSchluesseltoKunde");
	//
	// // GENAU einer erwartet.
	// return (List<Verbundschluessel>) q.getResultList();
	// }

}
