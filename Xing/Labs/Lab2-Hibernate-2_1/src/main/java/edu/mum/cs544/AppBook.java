package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;

public class AppBook {

    public static EntityManagerFactory emf;
    public static void main(String[] args){
        emf = Persistence.createEntityManagerFactory("cs544");
    //Tasks...
        //1.Open a EntityManager
        //2.Create 3 books save them to the database
        //3.Close the EntityManager
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Book b1 = new Book("Book on Java","ISBN 10","ABC", 100.0, Date.valueOf("2018-01-01"));
        Book b2 = new Book("Book on C++","ISBN 11","MNO", 70.0, Date.valueOf("2010-01-01"));
        Book b3 = new Book("Book on Spring","ISBN 12","XYZ", 150.0, Date.valueOf("2019-02-01"));
        em.persist(b1);
        em.persist(b2);
        em.persist(b3);
        em.getTransaction().commit();
        em.close();

        //1. Open a EntityManager
        //2. Retrieve all books and output them to the console
        //3. Close the EntityManager
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Book> query = em.createQuery("from Book",Book.class);
        List<Book> books = query.getResultList();
        for(Book bk:books){
            System.out.println(bk);
        }
        em.getTransaction().commit();
        em.close();

        //1.Open a EntityManager
        //2.Retrieve all books from the database, and then:
        //3.Change the title and price of one book
        //4.Use em.remove() to delete a different book (not the one that was just updated)
        //5.Close the EntityManager
        em = emf.createEntityManager();
        em.getTransaction().begin();
        query = em.createQuery("from Book",Book.class);
        books = query.getResultList();
        Book b0 = books.get(1);
        b0.setTitle("Book on HTML");
        b0.setPrice(120.0);
        em.remove(books.get(books.size()-1));
        em.getTransaction().commit();
        em.close();


        //1.Open a EntityManager
        //2.Retrieve all books and output them to the console
        //3.Close the EntityManager
        em = emf.createEntityManager();
        em.getTransaction().begin();
        query = em.createQuery("from Book",Book.class);
        books = query.getResultList();
        for(Book bk:books){
            System.out.println(bk);
        }
        em.getTransaction().commit();
        em.close();
    }
}
