package DepartmentEmployee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Department {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany
    @JoinColumn(name="employee_id")
    private List<Employee> empList;

    Department(String name){
        this.name = name;
        empList = new ArrayList<Employee>();
    }

    public void addEmployee(Employee employee){
        this.empList.add(employee);
        employee.setDepartment(this);
    }

}
