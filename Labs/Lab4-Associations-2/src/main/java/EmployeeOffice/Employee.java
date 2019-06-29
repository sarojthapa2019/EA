package EmployeeOffice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ManyToOne
    private Office office;

    Employee(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setOffice(Office office){
        this.office = office;
        office.addEmployee(this);
    }

    public Office getOffice(){
        return this.office;
    }
}
