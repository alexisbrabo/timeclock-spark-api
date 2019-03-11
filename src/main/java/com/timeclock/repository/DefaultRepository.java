package com.timeclock.repository;

import javax.persistence.EntityManager;

import com.timeclock.database.JpaUtils;

public class DefaultRepository {

	protected EntityManager manager = JpaUtils.getEntityManager();

	protected void save(Object object) {
		try {
			manager.getTransaction().begin();
			manager.persist(object);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}

	}
	
	protected void update(Object object) {
		try {
			manager.getTransaction().begin();
			manager.merge(object);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}

	}
	
	protected void delete(Object object) {
		try {
			manager.getTransaction().begin();
			manager.remove(object);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}

	}

}
