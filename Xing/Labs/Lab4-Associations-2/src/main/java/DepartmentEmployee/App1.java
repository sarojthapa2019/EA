package DepartmentEmployee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App1 {
    public static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();

        Department dept = new Department("Technical");
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();

        dept.addEmployee(emp1);
        dept.addEmployee(emp2);

        em.getTransaction().begin();
        em.persist(dept);
        em.persist(emp1);
        em.persist(emp2);
        em.getTransaction().commit();
        em.close();
    }
}
