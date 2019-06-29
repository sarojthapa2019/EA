package EmployeeOffice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Office {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(mappedBy = "office")
    private List<Employee> empList = new ArrayList<Employee>();

    Office(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public List<Employee> getEmpList(){
        return this.empList;
    }

    public void addEmployee(Employee emp){
        this.empList.add(emp);
    }

}
