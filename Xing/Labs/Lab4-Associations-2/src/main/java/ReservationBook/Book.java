package ReservationBook;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    Book(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
