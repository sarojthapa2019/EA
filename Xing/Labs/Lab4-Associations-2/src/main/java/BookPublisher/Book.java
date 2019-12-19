package BookPublisher;

import javax.persistence.*;

//@Entity
public class Book {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name="publisher_id")
    private Publisher publisher;

    Book(){}
    Book(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
