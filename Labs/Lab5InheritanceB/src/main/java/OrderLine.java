import javax.persistence.*;

@Entity
public class OrderLine {
    @Id
    @GeneratedValue
    private int id;
    private int quantity;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Product product;

    public OrderLine(){}

    public OrderLine(int quantity, Product p){
        this.quantity = quantity;
        this.product = p;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }
}
