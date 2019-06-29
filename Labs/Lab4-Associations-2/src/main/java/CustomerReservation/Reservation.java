package CustomerReservation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private int id;
    private String seat;

    Reservation(String seat){
        this.seat = seat;
    }

    public String getSeat(){
        return this.seat;
    }
}
