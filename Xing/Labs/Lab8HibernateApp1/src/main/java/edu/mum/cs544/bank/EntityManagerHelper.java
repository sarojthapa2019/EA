package edu.mum.cs544.bank;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {

    private static final EntityManagerFactory emf;
    private static final ThreadLocal<EntityManager> localTh;

    static {
        emf = Persistence.createEntityManagerFactory("cs544");
        localTh = new ThreadLocal<EntityManager>();
    }

    public static EntityManager getCurrent() {
        EntityManager em = localTh.get();
        if (em == null ||!em.isOpen()) {
            em = emf.createEntityManager();
            localTh.set(em);
        }
        return em;
    }

    public static void closeEntityManagerFactory() {
        emf.close();
    }
}