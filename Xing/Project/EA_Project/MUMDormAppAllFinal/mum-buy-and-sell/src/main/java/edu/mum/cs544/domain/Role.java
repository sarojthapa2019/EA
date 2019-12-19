package edu.mum.cs544.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rid;
    private String role;

    public Role() {
        this.role="USER";
    }

    @Override
    public String toString() {
        return role;
    }
}
