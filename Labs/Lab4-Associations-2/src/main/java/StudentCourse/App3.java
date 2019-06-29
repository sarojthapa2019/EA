package StudentCourse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class App3 {
    public static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();

        Course c1 = new Course(1,"EA");
        Course c2 = new Course(2, "WAA");

        Student s1 = new Student(1,"Sujiv");
        Student s2 = new Student(2,"Suman");

        s1.addCourse(c1);
        s1.addCourse(c2);

        s2.addCourse(c1);
        s2.addCourse(c2);

        em.getTransaction().begin();
        em.persist(s1);
        em.persist(s2);
        em.persist(c1);
        em.persist(c2);
        em.getTransaction().commit();

        Query q = em.createQuery("from Course",Course.class);
        List<Course> courses = q.getResultList();
        for(Course c:courses){
            for(Student std:c.getStudents())
                System.out.println("Course:"+c.getTitle()+" Student:"+std.getName());
        }

        em.close();
    }
}
