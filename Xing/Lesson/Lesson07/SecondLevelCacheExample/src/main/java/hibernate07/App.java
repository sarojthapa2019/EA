package hibernate07;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.stat.SecondLevelCacheStatistics;
import org.hibernate.stat.Statistics;

public class App {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs544");


    public static void main(String[] args) {
        try {
            persistEntity();

            for (int i=0; i < 3; i++){
                loadEntity();
            }
            statistics();
        } finally {
            emf.close();
        }
    }

    public static void persistEntity() {
        Customer customer = new Customer("Frank", "Brown");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
        em.close();
    }

    private static void loadEntity() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Customer employee = em.find(Customer.class, 1L);
        System.out.println("Customer loaded: " + employee);
        em.getTransaction().commit();
        em.close();
    }

    public static void statistics(){
        SessionFactory sessionFactory = emf.unwrap(SessionFactory.class);

        Statistics stats = sessionFactory.getStatistics();
        long hits   = stats.getSecondLevelCacheHitCount();
        long misses = stats.getSecondLevelCacheMissCount();
        long puts   = stats.getSecondLevelCachePutCount();
        System.out.printf("\nGeneral 2nd Level Cache Stats\n");
        System.out.printf("Hit: %d Miss: %d Put: %d\n", hits, misses, puts);

        org.hibernate.stat.CacheRegionStatistics customerCacheStats =
                stats.getCacheRegionStatistics("hibernate07.Customer");
        long srCurrent = customerCacheStats.getElementCountInMemory();
        long srMemsize = customerCacheStats.getSizeInMemory();
        long srHits    = customerCacheStats.getHitCount();
        long srMisses  = customerCacheStats.getMissCount();
        long srPuts    = customerCacheStats.getPutCount();
        System.out.printf("\ncustomerCache Cache Region - Size: %d Holds: %d\n", srMemsize, srCurrent);
        System.out.printf("Hit: %d Miss: %d Put: %d\n", srHits, srMisses, srPuts);

    }

}
