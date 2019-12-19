package EmployeeOffice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class App6 {
    public static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();

        Employee emp1 = new Employee("Sujiv");
        Employee emp2 = new Employee("Tina");
        Employee emp3 = new Employee("Renu");

        Office off = new Office("MUM");
        emp1.setOffice(off);
        emp2.setOffice(off);
        emp3.setOffice(off);

        em.getTransaction().begin();
        em.persist(emp1);
        em.persist(emp2);
        em.persist(emp3);
        em.persist(off);
        em.getTransaction().commit();

        Query q = em.createQuery("from Office",Office.class);
        List<Office> offices = q.getResultList();

        for(Office o:offices){
            for(Employee emp0:o.getEmpList()){
                System.out.println("Office:"+o.getName()+" Employee: "+emp0.getName());
            }
        }

        em.close();
    }
}
