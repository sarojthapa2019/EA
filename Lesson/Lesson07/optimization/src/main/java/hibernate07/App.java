package hibernate07;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs544");


    private static void lazyCollection() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Customer cust1 = new Customer("Frank", "Brown");
        Customer cust2 = new Customer("Jane", "Terrien");
        Customer cust3 = new Customer("John", "Doe");
        cust1.addBook(new Book("Harry Potter and the Deathly Hallows"));
        cust1.addBook(new Book("Unseen Academicals (Discworld)"));
        cust1.addBook(new Book("The Color of Magic (Discworld)"));
        cust1.addMovie(new Movie("Shrek"));
        cust1.addMovie(new Movie("WALL-E"));
        cust1.addMovie(new Movie("Howls Moving Castle"));
        cust2.addBook(new Book("Twilight (The Twilight Saga, Book1)"));
        cust3.addMovie(new Movie("Forgetting Sarah Marshall"));
        em.persist(cust1);
        em.persist(cust2);
        em.persist(cust3);

        em.getTransaction().commit();
        em.clear();

        System.out.println("------------------------------------------");
        em.getTransaction().begin();
        Customer c = em.find(Customer.class, 1L);
        System.out.println(c.getMovies().size());
        System.out.println("------------------------------------------");
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    private static void join2Collections_BAD() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Customer cust1 = new Customer("Frank", "Brown");
        Customer cust2 = new Customer("Jane", "Terrien");
        Customer cust3 = new Customer("John", "Doe");
        cust1.addBook(new Book("Harry Potter and the Deathly Hallows"));
        cust1.addBook(new Book("Unseen Academicals (Discworld)"));
        cust1.addBook(new Book("The Color of Magic (Discworld)"));
        cust1.addMovie(new Movie("Shrek"));
        cust1.addMovie(new Movie("WALL-E"));
        cust1.addMovie(new Movie("Howls Moving Castle"));
        cust2.addBook(new Book("Twilight (The Twilight Saga, Book1)"));
        cust3.addMovie(new Movie("Forgetting Sarah Marshall"));
        em.persist(cust1);
        em.persist(cust2);
        em.persist(cust3);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Object[]> query = em.createQuery(
                "from Customer c left join c.movies left join c.books", Object[].class);
        List<Object[]> customers = query.getResultList();


        em.getTransaction().commit();
        emf.close();
    }

    private static void nPlusOneProblem() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        SalesRep sr1 = new SalesRep("John Willis");
        SalesRep sr2 = new SalesRep("Mary Long");

        sr1.addCustomer(new Customer("Frank", "Brown"));
        sr1.addCustomer(new Customer("Jane", "Terrien"));
        sr2.addCustomer(new Customer("John", "Doe"));
        sr2.addCustomer(new Customer("Carol", "Reno"));

        em.persist(sr1);
        em.persist(sr2);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<SalesRep> query =
                em.createQuery("from SalesRep", SalesRep.class);
        List<SalesRep> salesReps = query.getResultList();

        for (SalesRep s : salesReps) {
            System.out.println("customer start--------");
            System.out.println(s.getCustomers().get(0));
            System.out.println("customer end--------");
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    private static void nPlusOneEargerLoading() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Customer cust1 = new Customer("Frank", "Brown");
        Customer cust2 = new Customer("Jane", "Terrien");
        Customer cust3 = new Customer("John", "Doe");
        Customer cust4 = new Customer("Carol", "Reno");
        cust1.setSalesRep(new SalesRep("John Willis"));
        cust2.setSalesRep(new SalesRep("Mary Long"));
        cust3.setSalesRep(new SalesRep("Ted Walker"));
        cust4.setSalesRep(new SalesRep("Keith Rogers"));

        em.persist(cust1);
        em.persist(cust2);
        em.persist(cust3);
        em.persist(cust4);
        em.getTransaction().commit();
        em.close();
        System.out.println();
        System.out.println();
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Customer> customers = em.createQuery("from Customer").getResultList();
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    private static void entityGraph() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Customer cust1 = new Customer("Frank", "Brown");
        Customer cust2 = new Customer("Jane", "Terrien");
        Customer cust3 = new Customer("John", "Doe");
        cust1.addBook(
                new Book("Harry Potter and the Deathly Hallows",
                        new Author("J.K. Rowlings")));
        cust1.addBook(
                new Book("Unseen Academicals (Discworld)",
                        new Author("Terry Pratchett")));
        cust1.addBook(
                new Book("The Color of Magic (Discworld)",
                        new Author("Terry Pratchett")));
        cust2.addBook(
                new Book("Twilight (The Twilight Saga, Book1)",
                        new Author("Stephenie Meyer")));
        cust1.setAddress(new Address("Fairfield", "Iowa"));
        cust2.setAddress(new Address("Chicago", "Illinois"));
        em.persist(cust1);
        em.persist(cust2);
        em.persist(cust3);

        em.getTransaction().commit();
        em.close();
        System.out.println();
        System.out.println();
        em = emf.createEntityManager();
        em.getTransaction().begin();

        EntityGraph<Customer> graph = em.createEntityGraph(Customer.class);
//        graph.addAttributeNodes("address");
        graph.addSubgraph("books").addAttributeNodes("author");
        TypedQuery<Customer> query = em.createQuery("from Customer where firstName like :name", Customer.class);
        query.setParameter("name", "J%");
        query.setHint("javax.persistence.fetchgraph", graph);

        List<Customer> customers = query.getResultList();
        System.out.println(customers.size());

        for (Customer customer : customers) {
            System.out.println("address......................");
            System.out.println(customer.getAddress());
            for (Book book : customer.getBooks()) {
                System.out.println("book......................author");
                System.out.println(book);
                System.out.println(book.getAuthor());
            }
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    /**
     * For this demo:
     * comment/uncomment @Fetch(FetchMode.SUBSELECT) in SalesRep class to see the difference
     */
    private static void subselect() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        SalesRep sr1 = new SalesRep("John Willis");
        SalesRep sr2 = new SalesRep("Mary Long");

        sr1.addCustomer(new Customer("Frank", "Brown"));
        sr1.addCustomer(new Customer("Jane", "Terrien"));
        sr2.addCustomer(new Customer("John", "Doe"));
        sr2.addCustomer(new Customer("Carol", "Reno"));

        em.persist(sr1);
        em.persist(sr2);
        em.getTransaction().commit();
        em.close();

        System.out.println();
        System.out.println();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("Before query");
        TypedQuery<SalesRep> query =
                em.createQuery("from SalesRep where id < 1000", SalesRep.class);
        List<SalesRep> salesReps = query.getResultList();
        System.out.println("After query");
        for (SalesRep s : salesReps) {
            s.getCustomers().get(0).getFirstName();
        }
        System.out.println("After loop");


        em.getTransaction().commit();
        em.close();
        emf.close();
    }


    public static void main(String[] args) {
//		lazyCollection();
//        join2Collections_BAD();
//        nPlusOneProblem();
//        nPlusOneEargerLoading();
//        entityGraph();
        subselect();
    }


}
