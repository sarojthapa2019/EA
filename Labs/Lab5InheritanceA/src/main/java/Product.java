import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;

    public Product(){}
    public Product(String name, String desc){
        this.name = name;
        this.description = desc;
    }

    @Override
    public String toString(){
        return ""+id+": "+name+"{"+description+"}";
    }
}
