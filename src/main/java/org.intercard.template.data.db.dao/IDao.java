package org.intercard.template.data.db.dao;

import java.util.List;

import org.intercard.template.data.db.ex.DataException;

public interface IDao<T> {

	// -------------------------------------------------------------------------
	// create, save, update, delete by Object
	// -------------------------------------------------------------------------
	public T findOne(int id) throws DataException;

	public List<T> findAll() throws DataException;

	public T doSave(T entity) throws DataException;

	public T doUpdate(T entity) throws DataException;

	public void doDelete(T entity) throws DataException;
}
