package edu.mum.cs544.bank.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
