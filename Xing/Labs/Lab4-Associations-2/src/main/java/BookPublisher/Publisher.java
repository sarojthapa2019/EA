package BookPublisher;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

//@Entity
public class Publisher {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    Publisher(){}
    Publisher(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
