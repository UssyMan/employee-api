package com.uthmanIV.RestAPI.service;

import com.uthmanIV.RestAPI.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findALl();
    Employee findById(int id);
    Employee addEmployee(Employee e);
    Employee updateEmployee(Employee e);
    void delete(int id);
}
