package cs544.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Car {

    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String make;
    @NotEmpty
    private String model;
    @Range(min = 1940, max = 2019)
    private Integer year;
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
