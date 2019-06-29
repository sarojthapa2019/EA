package BookPublisher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class App2 {
    public static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();

        Publisher pb = new Publisher("Janak");
        Book bk1 = new Book("Java");
        Book bk2 = new Book("HTML");

        bk1.setPublisher(pb);
        bk2.setPublisher(pb);

        em.getTransaction().begin();
        em.persist(bk1);
        em.persist(bk2);
        em.persist(pb);
        em.getTransaction().commit();

        Query q = em.createQuery("from Book",Book.class);
        List<Book> bkList = q.getResultList();
        for(Book bk:bkList){
            System.out.println("Book:"+bk.getName()+" Publisher:"+bk.getPublisher().getName());
        }
        em.close();
    }
}
