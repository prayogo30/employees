package com.prayogo.employee.service;

import com.prayogo.employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getEmployeeList();

    Employee updateEmployee(Employee employee, Long id);
}
