package cs544.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Car {

    @Id
    @GeneratedValue
    private Long id;
    private String make;
    private String model;
    private int year;
    private String color;

    public Car() {
    }

    public Car(String make, String model, int year, String color) {
        super();
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

}
