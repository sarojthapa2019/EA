package edu.mum.cs.springbootwebjspdemo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "String.empty")
    private String street;
    private String city;

    @Size(min = 2, max = 2, message = "Size.state")
    private String state;

    private String zipCode;

}
