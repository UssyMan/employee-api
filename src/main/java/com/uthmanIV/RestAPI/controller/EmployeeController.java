package com.uthmanIV.RestAPI.controller;

import com.uthmanIV.RestAPI.DAO.EmployeeDAO;
import com.uthmanIV.RestAPI.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeDAO.findALl();
    }
}
