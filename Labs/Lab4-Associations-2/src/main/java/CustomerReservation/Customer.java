package CustomerReservation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany
    private List<Reservation> reservations;

    Customer(){reservations = new ArrayList<Reservation>(); }

    Customer(String name){
        reservations = new ArrayList<Reservation>();
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void addReservation(Reservation res){
        this.reservations.add(res);
    }

    public List<Reservation> getReservations(){
        return this.reservations;
    }
}
