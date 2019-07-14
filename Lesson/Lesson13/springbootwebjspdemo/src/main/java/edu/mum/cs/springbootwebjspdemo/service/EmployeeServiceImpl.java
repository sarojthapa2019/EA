package edu.mum.cs.springbootwebjspdemo.service;

import edu.mum.cs.springbootwebjspdemo.domain.Employee;
import edu.mum.cs.springbootwebjspdemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
}
