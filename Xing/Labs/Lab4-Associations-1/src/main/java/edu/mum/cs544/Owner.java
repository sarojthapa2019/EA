package edu.mum.cs544;

import javax.persistence.*;

@Entity
@Table(name="owner")
public class Owner {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    public Owner(){}

    public Owner(String name, String add) {
        this.name = name;
        this.address = add;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
