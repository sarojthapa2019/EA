package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings("Duplicates")
public class App {

    public static EntityManagerFactory emf;
    public static void main(String[] args){
        emf = Persistence.createEntityManagerFactory("cs544");
        //1.Open a EntityManager
        //2.Retrieve all students from the database and display their names important: your query needs to be:  from edu.mum.cs544.Students
        //3.Close the EntityManager
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Students> allStudentsQuery = em.createQuery("from edu.mum.cs544.Students",Students.class);
        List<Students> studentsList = allStudentsQuery.getResultList();
        for(Students s: studentsList){
            System.out.println(s.getName()+" ["+s+"]");
        }
        em.getTransaction().commit();
        em.close();

        //1.Open a EntityManager
        //2.Add an extra student to the database (you can choose his / her name)
        //3.Close the EntityManager
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Students s1 = new Students();
        s1.setId(1000);
        s1.setName("Sujiv");
        s1.setEmail("sujiv@mum.edu");
        s1.setPassword("xyz");

        //em.remove(studentsList.get(4));
        if(!studentsList.contains(s1))
            em.persist(s1);

        em.getTransaction().commit();
        em.close();

        //1.Open a EntityManager
        //2.Retrieve all students again from the database and display their names
        //3.Close the EntityManager
        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Students> allStudentsQuery2 = em.createQuery("from edu.mum.cs544.Students",Students.class);
        List<Students> studentsList2 = allStudentsQuery2.getResultList();
        for(Students s: studentsList2){
            System.out.println(s.getName()+" ["+s+"]");
        }
        em.getTransaction().commit();
        em.close();
    }
}
