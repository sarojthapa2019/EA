import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.util.List;

public class App {
    static EntityManagerFactory emf;
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();

        Customer cus = new Customer("Sujiv", "Shrestha");
//      Product p1 = new Product("White","Toothpaste");
        Product p1 = new CD("CD1","Nepali Songs","Sugam");
        Product p2 = new DVD("DVD1","Movies","Romantic");
        Product p3 = new Book("Book1","Book by Rod","Enterprise Architecture");

        OrderLine ol1 = new OrderLine(10,p1);
        OrderLine ol2 = new OrderLine(5,p2);
        OrderLine ol3 = new OrderLine(2,p3);
        Order o1 = new Order(Date.valueOf("2019-06-30"));

        o1.addOrderLine(ol1);
        o1.addOrderLine(ol2);
        o1.addOrderLine(ol3);
        cus.addOrder(o1);

        em.getTransaction().begin();
        em.persist(cus);
        em.getTransaction().commit();

        em.getTransaction().begin();
        List<Customer> custList = em.createQuery("from Customer",Customer.class).getResultList();
        for (Customer c:custList) {
            System.out.println("Customer id: "+c.getId()+"\tFirstName: "+c.getFirstName()+"\tLastName: "+c.getLastName());
            for(Order o:c.getOrders()){
                System.out.println("Order id:"+o.getOrderid()+"\tDate: "+o.getDate().toString()+"\tCustomer id:"+o.getCustomer().getId());
                for(OrderLine ol:o.getOrderLines()){
                    System.out.println("OrderLine id:"+ol.getId()+"\tProduct:"+ol.getProduct()+"\tQty. :"+ol.getQuantity());
                }
            }
        }

        em.getTransaction().commit();
        em.close();
    }
}
