package co.in.boot.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, ID extends Serializable> {

	/**
	 *
	 * This <code>getAll</code> method is used for get all records.
	 *
	 * @param <T>
	 *
	 * @return
	 */
	public List<T> findAll();

	/**
	 *
	 * This <code>delete</code> method is used for delete single record.
	 *
	 * @param <T>
	 *
	 * @param t
	 * @return
	 */
	public void delete(T t);

	/**
	 *
	 * This <code>update</code> method is used for update record.
	 *
	 * @param <T>
	 *
	 * @param t
	 * @return
	 */
	public T saveORupdate(T t);

	/**
	 *
	 * This <code>findOne</code> method is used for find single record by id.
	 *
	 * @param <T>
	 *
	 * @param id
	 * @return
	 */
	public T findOne(ID id);

	/**
	 *
	 * This <code>deleteById</code> method is used for delete record by id.
	 *
	 * @param id
	 * @return
	 */
	public void deleteById(ID id);

}
