package edu.mum.cs544;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AppCar {

	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Owner owner = new Owner("Sujiv","Nepal");
        // Create new instance of Car and set values in it
        Car car1 = new Car("BMW", "2019", 80221.00);
        car1.setOwner(owner);
        // save the car
        em.persist(car1);
        // Create new instance of Car and set values in it
        Car car2 = new Car("Mercedes", "2020", 74088.00);
        car2.setOwner(owner);
        // save the car
        em.persist(car2);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all cars
        TypedQuery<Car> query = em.createQuery("from Car", Car.class);
        List<Car> carList = query.getResultList();
        for (Car car : carList) {
            System.out.println("brand= " + car.getBrand() + ", year= "
                    + car.getYear() + ", price= " + car.getPrice());
            System.out.println("Owner: "+car.getOwner().getName());
        }
        em.getTransaction().commit();
        em.close();
    }
}

