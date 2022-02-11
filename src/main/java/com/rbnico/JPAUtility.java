package com.rbnico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtility {
    private static EntityManager entityManager;

    private JPAUtility(){}

    public static EntityManager getEntityManager()
    {
        if (entityManager == null)
        {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("simplyteaching.odb");
            entityManager = entityManagerFactory.createEntityManager();
        }

        return entityManager;
    }
}
