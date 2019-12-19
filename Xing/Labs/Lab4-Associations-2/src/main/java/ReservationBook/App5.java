package ReservationBook;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class App5 {
    public static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();

        Reservation res1 = new Reservation("C112");
        Reservation res2 = new Reservation("C100");
        Book bk1 = new Book("Book1");

        res1.setBook(bk1);
        res2.setBook(bk1);

        em.getTransaction().begin();
        em.persist(res1);
        em.persist(res2);
        em.persist(bk1);

        em.getTransaction().commit();

        Query q = em.createQuery("from Reservation",Reservation.class);
        List<Reservation> resList = q.getResultList();
        for(Reservation resv: resList){
            System.out.println("Reservation code:"+resv.getCode()+" book:"+resv.getBook().getName());
        }

        em.close();
    }
}
