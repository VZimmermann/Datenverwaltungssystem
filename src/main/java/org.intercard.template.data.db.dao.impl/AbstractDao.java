package org.intercard.template.data.db.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.intercard.template.data.db.dao.IDao;
import org.intercard.template.data.db.ex.DataException;

public abstract class AbstractDao<T extends Serializable> implements IDao<T> {

	protected Class<T> domainClass = getDomainClass();

	/**
	 * Method to return the class of the domain object
	 */
	protected abstract Class<T> getDomainClass();

	EntityManager entityManager;

	@PersistenceContext(unitName = "jpa-persistence")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public T findOne(int id) throws DataException {
		try {
			return this.entityManager.find(this.domainClass, id);
		} catch (Exception e) {
			throw new DataException("", e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() throws DataException {
		try {
			return this.entityManager
					.createQuery(
							"select t from " + this.domainClass.getSimpleName()
									+ " t ").getResultList();
		} catch (Exception e) {
			throw new DataException("", e);
		}
	}

	public T doSave(T entity) throws DataException {
		try {
			entityManager.persist(entity);
			return entityManager.merge(entity);

		} catch (Exception e) {
			throw new DataException("", e);
		}
	}

	public T doUpdate(T entity) throws DataException {
		try {
			return entity = entityManager.merge(entity);
		} catch (Exception e) {
			throw new DataException("", e);
		}
	}

	public void doDelete(T entity) throws DataException {
		try {
			T nEntity = entityManager.merge(entity);
			entityManager.remove(nEntity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataException("", e);
		}

	}
}
