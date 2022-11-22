package com.netbiis.wassabiapp_jsp.model.helper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerHelper {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	public static EntityManager getEntityManager() {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("wasabi_app");
			entityManager = entityManagerFactory.createEntityManager();

			return entityManager;
		} catch (Exception error) {
			System.out.println(error.getMessage());
			throw error;
		}
	}

	public static void close() {
		entityManager.close();
		entityManagerFactory.close();
	}
}
