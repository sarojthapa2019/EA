package ReservationBook;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private int id;
    private String code;
    @ManyToOne
    private Book book;

    Reservation(String code){
        this.code = code;
    }

    public String getCode(){
        return this.code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public void setBook(Book bk){
        this.book = bk;
    }

    public Book getBook(){
        return this.book;
    }

}
