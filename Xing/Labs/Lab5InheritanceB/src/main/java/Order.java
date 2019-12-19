import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "`Order`")
public class Order {
    @Id
    @GeneratedValue

    private int orderid;
    private Date date;
    @ManyToOne
    private Customer customer;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="order_id")
    private List<OrderLine> orderLines = new ArrayList<OrderLine>();

    public Order(){}

    public Order(Date dt){
        this.date = dt;
    }

    public int getOrderid(){
        return this.orderid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addOrderLine(OrderLine ol){
        this.orderLines.add(ol);
    }

    public List<OrderLine> getOrderLines(){
        return  this.orderLines;
    }
}
