package hibernate06;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

public class App {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs544");

    private static void createQuery() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("from Person");
        List<Person> ppl = query.getResultList();
        System.out.println(ppl);
        em.getTransaction().commit();
        em.close();
    }

    private static void namedQuery() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Person> q = em.createNamedQuery("Person.Everybody", Person.class);
        List<Person> ppl = q.getResultList();
        System.out.println(ppl);
        em.getTransaction().commit();
        em.close();
    }

    private static void pagination() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Person> pplQuery = em.createQuery("from Person", Person.class);

        pplQuery.setFirstResult(0); //Set the position of the first result to retrieve.
        pplQuery.setMaxResults(5);

        List<Person> ppl = pplQuery.getResultList();
        for (Person p : ppl) {
            System.out.println(p);
        }
        em.getTransaction().commit();
        em.close();
    }


    private static void indexedCollection() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p1 = new Person("John", "Johnson");
        p1.setAddress(em.getReference(Address.class, 1L));
        p1.addAccount(new SavingsAccount(1000.00, 2.0));
        p1.addAccount(new CheckingAccount(1000.00, 200.0));
        em.persist(p1);

        em.getTransaction().commit();
        em.getTransaction().begin();
        TypedQuery<Person> query
                = em.createQuery("from Person p where p.accounts[0].balance > 100", Person.class);
        System.out.println(query.getResultList());

        em.getTransaction().commit();
        em.close();
    }

    private static void specialAttributeId() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee e = new Employee("Tina", "Xing");
        em.persist(e);

        Employee e2 = em.createQuery("from Employee where id = 1", Employee.class).getSingleResult();
        System.out.println(e2);

        em.getTransaction().commit();
    }

    private static void specialAttributeClass() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p1 = new Person("John", "Johnson");
        p1.setAddress(em.getReference(Address.class, 1L));
        p1.addAccount(new SavingsAccount(1000.00, 2.0));
        p1.addAccount(new CheckingAccount(5000.00, 200.0));
        p1.addAccount(new SavingsAccount(2000.00, 1.0));
        p1.addAccount(new CheckingAccount(3000.00, 500.0));
        em.persist(p1);

        em.getTransaction().commit();
        em.getTransaction().begin();

        List<Account> accounts = em.createQuery("from Account a where a.class <> CheckingAccount", Account.class).getResultList();
        System.out.println(accounts);

        List<Account> accounts2 = em.createQuery("from Account a where type(a) = CheckingAccount", Account.class)
                .getResultList();
        System.out.println(accounts2);

        em.getTransaction().commit();
        em.close();
    }

    private static void join() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p1 = new Person("John", "Johnson");
        p1.setAddress(new Address("1001 N 5th St", "Fairfield", "IA", "52556"));
        em.persist(p1);

        System.out.println("1");

        em.createQuery("select p from Person as p JOIN p.address as a where a.city = 'Fairfield'", Person.class).getResultList();

        System.out.println("2");

        em.createQuery("from Person as p where p.address.city = 'Fairfield'", Person.class).getResultList();

        System.out.println("3");
        em.getTransaction().commit();
        em.close();
    }

    public static void distinct() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person p1 = new Person("John", "Brown");
        p1.addPhonenumber(new PhoneNumber("641-472-1234", "Home"));
        p1.addPhonenumber(new PhoneNumber("641-919-5432", "Mobile"));
        em.persist(p1);

        Person p2 = new Person("Edward", "Towers");
        p2.addPhonenumber(new PhoneNumber("641-233-9876", "Mobile"));
        p2.addPhonenumber(new PhoneNumber("641-888-0987", "Home"));
        em.persist(p2);

        System.out.println("1");

       /* Query q = em.createQuery("from Person p join p.numbers as n where n.number like '641%'");
        List<Object> result = q.getResultList();*/
        //Without select, gonna return a bigger set
        List<Object[]> results = em.createQuery("from Person p join p.numbers as n where n.number like '641%'", Object[].class).getResultList();
        for (Object[] row : results) {
            System.out.println((Person) row[0]);
            System.out.println((PhoneNumber) row[1]);
        }
        System.out.println("2");

        List<Person> people = em.createQuery("select p from Person p "
                + "join p.numbers as n "
                + "where n.number like '641%'", Person.class).getResultList();
        System.out.println(people);
        System.out.println("people size: " + people.size());

        System.out.println("3");

        List<Person> distinctPeople = em.createQuery("select distinct p from Person p "
                + "join p.numbers as n "
                + "where n.number like '641%'", Person.class).getResultList();

        System.out.println(distinctPeople);
        System.out.println("Distinct people size: " + distinctPeople.size());

        System.out.println("4");

        em.getTransaction().commit();
        em.close();
    }

    public static void joinFetch() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p1 = new Person("John", "Brown");
        p1.addPhonenumber(new PhoneNumber("641-472-1234", "Home"));
        p1.addPhonenumber(new PhoneNumber("641-919-5432", "Mobile"));
        em.persist(p1);

        Person p2 = new Person("Edward", "Towers");
        p2.addPhonenumber(new PhoneNumber("641-233-9876", "Mobile"));
        p2.addPhonenumber(new PhoneNumber("641-888-0987", "Home"));
        em.persist(p2);

        em.getTransaction().commit();
        em.close();

        //you have to use Two entity manger to see the N+1 behavior. one EM one cache
        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Person> query
                = em.createQuery("from Person", Person.class);
        List<Person> people = query.getResultList();

        for (Person p : people) {
            System.out.println(p.getFirstName() + " " + p.getLastName());
            System.out.println("1------------");
            p.getNumbers().forEach(phoneNumber -> {
                System.out.println(phoneNumber.getId() + ", balance: " + phoneNumber.getNumber());
            });
            System.out.println("2--------------");
        }

        em.getTransaction().commit();
        em.close();

        System.out.println();
        System.out.println("==============================================================");
        System.out.println();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Person> query2
                = em.createQuery("select distinct p from Person p join fetch p.numbers", Person.class);
        List<Person> people2 = query2.getResultList();

        for (Person p : people2) {
            System.out.println(p.getFirstName() + " " + p.getLastName());
            System.out.println("3------------");
            p.getNumbers().forEach(phoneNumber -> {
                System.out.println(phoneNumber.getId() + ", balance: " + phoneNumber.getNumber());
            });
            System.out.println("4--------------");
        }
        em.getTransaction().commit();
        em.close();


        System.out.println();
        System.out.println("***************************************************");
        System.out.println();


        em = emf.createEntityManager();
        em.getTransaction().begin();

        //join doesn't work, still N+1 problem - only retrieve p here
        TypedQuery<Person> query3
                = em.createQuery("select distinct p from Person p join p.numbers", Person.class);
        List<Person> people3 = query3.getResultList();

        for (Person p : people3) {
            System.out.println(p.getFirstName() + " " + p.getLastName());
            System.out.println("5------------");
            p.getNumbers().forEach(phoneNumber -> {
                System.out.println(phoneNumber.getId() + ", balance: " + phoneNumber.getNumber());
            });
            System.out.println("6--------------");
        }
        em.getTransaction().commit();
        em.close();
    }

    private static void newList() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person p1 = new Person("John", "Brown");
        p1.addPhonenumber(new PhoneNumber("641-472-1234", "Home"));
        p1.addPhonenumber(new PhoneNumber("641-919-5432", "Mobile"));
        em.persist(p1);

        Person p2 = new Person("Edward", "Towers");
        p2.addPhonenumber(new PhoneNumber("641-233-9876", "Mobile"));
        p2.addPhonenumber(new PhoneNumber("641-888-0987", "Home"));
        em.persist(p2);

        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();


        //p and n are alias of person and p.numbers
        Query q = em.createQuery("select new list(p, n) from Person p join p.numbers n");

        List<List<Object>> result = q.getResultList();

        for (List<Object> item : result) {
            Person p = (Person) item.get(0);
            PhoneNumber phoneNumber = (PhoneNumber) item.get(1);

            System.out.println(p.getFirstName() + " " + p.getLastName()
                    + " has phone " + phoneNumber.getNumber());
        }

        em.getTransaction().commit();
        em.close();
    }

    private static void newObject(){

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p1 = new Person("John", "Johnson");
        p1.setAddress(new Address("111 2nd St", "Iowa City", "IA", "99999"));
        em.persist(p1);
        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Home> query = em.createQuery(
                "select new hibernate06.Home(p, a) from Person p join p.address a ", Home.class);
        List<Home> homes = query.getResultList();

        Person p = null;
        Address a = null;
        for (Home home : homes) {
            p = home.getPerson();
            a = home.getAddress();

            System.out.println(p.getFirstName() + " " + p.getLastName() + " has a home in " + a.getCity());
        }

        em.getTransaction().commit();
        em.close();
    }

    private static void criteria(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p1 = new Person("John", "Johnson");
        p1.setAddress(new Address("111 2nd St", "Iowa City", "IA", "99999"));
        em.persist(p1);
        Person p2 = new Person("Edward", "James");
        p2.setAddress(new Address("1000 4th St", "Fairfield", "IA", "52557"));
        em.persist(p2);

        Person p3 = new Person("John", "Johnson");
        p3.setAddress(new Address("1000 4th St", "Fairfield", "IA", "52557"));
        em.persist(p3);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);
        Root<Person> person = cq.from(Person.class);
        Join<Person, Address> address = person.join("address");
        cq.where(
                cb.and(
                        cb.equal(person.get("firstName"), "John"),
                        cb.equal(address.get("city"), "Fairfield")
                )
        );

        TypedQuery<Person> query = em.createQuery(cq);
        List<Person> ppl = query.getResultList();

        for (Person p : ppl) {
            System.out.println(p.getFirstName() + " " + p.getLastName());
            System.out.println("1------------");
            System.out.println(p.getAddress().getCity());
            System.out.println("2--------------");
        }
        em.getTransaction().commit();
        em.close();
    }

    private static void storedProcedure(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        StoredProcedureQuery query = em.createStoredProcedureQuery("calculate");

        query.registerStoredProcedureParameter("x", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("y", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("sum", Integer.class, ParameterMode.OUT);
        query.registerStoredProcedureParameter("prod", Integer.class, ParameterMode.OUT);

        query.setParameter("x", 2);
        query.setParameter("y", 3);
        query.execute();

        int sum = (int) query.getOutputParameterValue("sum");
        int prod = (int) query.getOutputParameterValue("prod");
        System.out.println("sum: " + sum + " prod: " + prod);
        em.getTransaction().commit();
        em.close();
    }

    private static void nativeQuery(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

//        Query query = em.createNativeQuery("SELECT * FROM Person", Person.class);
//        List<Person> ppl = query.getResultList();
//        ppl.forEach(x -> System.out.println(x.getFirstName()));

        Query query = em.createNativeQuery("SELECT * FROM Person");
        List<Object[]> ppl = query.getResultList();
        ppl.forEach(x -> System.out.println(x[1]));

        em.getTransaction().commit();
        em.close();
    }


    public static void main(String[] args) throws ParseException {
        EntityManager em = emf.createEntityManager();
//        createQuery();
//        namedQuery();
//        pagination();
//        indexedCollection();
//        specialAttributeId();
//        specialAttributeClass();
//        join();
//        distinct();
//        joinFetch();
//        newList();
//        newObject();
//        criteria();
//        storedProcedure();
//        nativeQuery();
        emf.close();
    }

}
