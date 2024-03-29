package edu.mum.cs.onetomanybitable;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppMain {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        /* Reads META-INF/persistence.xml and looks for specified unit name */

        emf = Persistence.createEntityManagerFactory("edu.mum.cs");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Car car1 = new Car(1996, "Honda", "Accord");
        Car car2 = new Car(1996, "Volvo", "S80");

        Person p = new Person("Frank", "Brown");
        p.addCar(car1);
        p.addCar(car2);
        em.persist(p);

        em.getTransaction().commit();
        emf.close();
    }

}
