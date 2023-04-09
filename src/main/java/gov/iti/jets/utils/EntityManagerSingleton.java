package gov.iti.jets.utils;

import jakarta.persistence.EntityManager;

public class EntityManagerSingleton {

    private static EntityManager entityManager = null;

    private EntityManagerSingleton() {
    }

    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            entityManager = EntityManagerFactorySingleton.getEntityManagerFactory()
                    .createEntityManager();
            return entityManager;

        } else
            return entityManager;
    }
}
