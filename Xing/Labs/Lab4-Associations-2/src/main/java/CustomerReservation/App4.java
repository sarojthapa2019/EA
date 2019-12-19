package CustomerReservation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class App4 {
    public static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();

        Customer c = new Customer("Sujiv");
        Reservation r1 = new Reservation("A1");
        Reservation r2 = new Reservation("H1");

        c.addReservation(r1);
        c.addReservation(r2);

        em.getTransaction().begin();
        em.persist(c);
        em.persist(r1);
        em.persist(r2);
        em.getTransaction().commit();

        Query q = em.createQuery("from Customer",Customer.class);
        List<Customer> custList = q.getResultList();

        for(Customer c0:custList){
            for(Reservation r0:c0.getReservations()){
                System.out.println("Customer:"+c0.getName()+" Reserves:"+r0.getSeat());
            }
        }

        em.close();
    }
}
