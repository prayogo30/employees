package com.prayogo.employee.service.impl;

import com.prayogo.employee.model.Employee;
import com.prayogo.employee.repository.EmployeeRepository;
import com.prayogo.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee){
        if (employee.getGrade().equals(1)){
            long bonus = employee.getSalary() * 10 / 100 ;
            long total = employee.getSalary() + bonus;
            employee.setTotalbonus(total);
        } else if (employee.getGrade().equals(2)){
            long bonus = employee.getSalary() * 6 / 100 ;
            long total = employee.getSalary() + bonus;
            employee.setTotalbonus(total);
        } else if (employee.getGrade().equals(3)) {
            long bonus = employee.getSalary() * 3 / 100 ;
            long total = employee.getSalary() + bonus;
            employee.setTotalbonus(total);
        }
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeeList() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {

        Employee empMd = employeeRepository.findById(id).get();

        if (!employee.getName().isEmpty()){
            empMd.setName(employee.getName());
        }

        if (!employee.getGrade().toString().isEmpty()){
            if (employee.getGrade().equals(1)){
                long bonus = employee.getSalary() * 10 / 100 ;
                long total = employee.getSalary() + bonus;
                empMd.setTotalbonus(total);
            } else if (employee.getGrade().equals(2)){
                long bonus = employee.getSalary() * 6 / 100 ;
                long total = employee.getSalary() + bonus;
                empMd.setTotalbonus(total);
            } else if (employee.getGrade().equals(3)) {
                long bonus = employee.getSalary() * 3 / 100 ;
                long total = employee.getSalary() + bonus;
                empMd.setTotalbonus(total);
            }
            empMd.setGrade(employee.getGrade());
        }

        if (!employee.getSalary().toString().isEmpty()){
            empMd.setSalary(employee.getSalary());
        }

        return employeeRepository.save(empMd);
    }


}
