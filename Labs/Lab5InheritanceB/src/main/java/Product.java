import javax.persistence.*;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Inheritance(strategy = InheritanceType.JOINED)
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
