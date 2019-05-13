package co.in.boot.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import co.in.boot.dao.BaseDao;
import co.in.boot.util.DaoFactory;

public class BaseServiceImpl<T, ID extends Serializable> {

	@Autowired
	private DaoFactory daoFactory;

	protected BaseDao<T, ID> baseDao;

	/**
	 * @return the daoFactory
	 */
	public DaoFactory getDaoFactory() {

		return daoFactory;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see uk.co.xcordis.tug.services.BaseService#findAll()
	 */
	@SuppressWarnings("hiding")
	public List<T> findAll() {

		return (List<T>) baseDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see uk.co.xcordis.tug.services.BaseService#delete(java.lang.Object)
	 */
	@SuppressWarnings("hiding")
	public void delete(final T t) {

		baseDao.delete(t);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see uk.co.xcordis.tug.services.BaseService#saveORupdate(java.lang.Object)
	 */
	@SuppressWarnings("hiding")
	public T saveORupdate(final T t) {

		return baseDao.save(t);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see uk.co.xcordis.tug.services.BaseService#findOne(java.lang.Object)
	 */
	@SuppressWarnings("hiding")
	public T findOne(final ID id) {

		final Optional<T> findById = baseDao.findById(id);
		return findById.isPresent() ? findById.get() : null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see uk.co.xcordis.tug.services.BaseService#deleteById(java.lang.Object)
	 */
	@SuppressWarnings("hiding")
	public void deleteById(final ID id) {

		baseDao.deleteById(id);
	}
}