import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    private List<Order> orders = new ArrayList<Order>();

    public Customer(){};
    public Customer(String fn, String ln){
        this.firstName = fn;
        this.lastName = ln;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void addOrder(Order o){
        this.orders.add(o);
        o.setCustomer(this);
    }

    public List<Order> getOrders(){
        return this.orders;
    }
}
