package edu.mum.cs544;

import java.util.List;

import javax.persistence.*;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        long start = System.nanoTime();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        EntityGraph<Owner> graph = em.createEntityGraph(Owner.class);
        graph.addAttributeNodes("pets");
//      TypedQuery<Owner> query = em.createNamedQuery("Owner.ownerList", Owner.class);
//      TypedQuery<Owner> query = em.createQuery("select O from Owner O Join Fetch O.pets", Owner.class);
        TypedQuery<Owner> query = em.createQuery("from Owner", Owner.class);
        query.setHint("javax.persistence.fetchgraph",graph);
//        query.setMaxResults(2);
        List<Owner> ownerlist = query.getResultList();
        for (Owner o : ownerlist) {
            System.out.println(o);
        }

        em.getTransaction().commit();
        em.close();
        long stop = System.nanoTime();

        // stop time
        System.out.println("To fetch this data from the database took " + (stop - start) / 1000000 + " milliseconds.");
        System.exit(0);
    }

}
