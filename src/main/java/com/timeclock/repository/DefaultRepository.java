package com.timeclock.repository;

import javax.persistence.EntityManager;

import com.timeclock.database.JpaUtils;

public class DefaultRepository {

	protected EntityManager manager = JpaUtils.getEntityManager();

	public void save(Object object) {
		try {
			manager.getTransaction().begin();
			manager.persist(object);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}

	}

	public void update(Object object) {
		try {
			manager.getTransaction().begin();
			manager.merge(object);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}

	}

	public void delete(Object object) {
		try {
			manager.getTransaction().begin();
			manager.remove(object);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}

	}

	public Object findById(Class<?> objectClass, Integer id) {
		return manager.find(objectClass, id);
	}

}
