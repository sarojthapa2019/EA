package edu.mum.cs.springbootwebjspdemo.repository;

import edu.mum.cs.springbootwebjspdemo.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
