package com.prayogo.employee.controller;

import com.prayogo.employee.model.Employee;
import com.prayogo.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/saveEmployee")
    public Employee saveEmployee(@Valid @RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping(value = "/getEmployee")
    public List<Employee> getEmployeeList() {
        return employeeService.getEmployeeList();
    }

    @PutMapping(value = "/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long id){
        return employeeService.updateEmployee(employee, id);
    }
}
