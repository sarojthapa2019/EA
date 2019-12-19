package edu.mum.cs544.domain;

import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Address {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;
    @SafeHtml
    @NotEmpty
    private String address;


    private String dormNumber;

    private String roomNumber;

    public Address() {
    }

    public Address(String address, String dormNumber, String roomNumber) {
        this.address = address;
        this.dormNumber = dormNumber;
        this.roomNumber = roomNumber;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDormNumber() {
        return dormNumber;
    }

    public void setDormNumber(String dormNumber) {
        this.dormNumber = dormNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "aid=" + aid +
                ", address='" + address + '\'' +
                ", dormNumber=" + dormNumber +
                ", roomNumber=" + roomNumber +
                '}';
    }
}
