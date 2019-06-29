package DepartmentEmployee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ManyToOne
    private Department department;

    Employee(){}
    Employee(String name){
        this.name = name;
    }

    public void setDepartment(Department dept){
        this.department = dept;
    }

}
