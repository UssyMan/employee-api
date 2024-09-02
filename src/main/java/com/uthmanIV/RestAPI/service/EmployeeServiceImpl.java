package com.uthmanIV.RestAPI.service;

import com.uthmanIV.RestAPI.entity.Employee;
import com.uthmanIV.RestAPI.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findALl() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        Employee employee = null;
        if (employeeOptional.isPresent()){
            employee = employeeOptional.get();
        }
        throw new RuntimeException("Employee not found with id -" + id);
    }

    @Override
    public Employee addEmployee(Employee e) {
        Optional<Employee> optionalEmployee = employeeRepository.findByEmail(e.getEmail());
        if (optionalEmployee.isPresent()){
            throw new RuntimeException("Employee Exist with email:" + e.getEmail());
        }
        else{
            return employeeRepository.save(e);
        }

    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findByEmail(employee.getEmail());
         if (optionalEmployee.isPresent()){
             return employeeRepository.save(employee);
         }
        else {
            throw new RuntimeException("Employee does not exist");
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee employee = null;
        if (optionalEmployee.isPresent()){
            employee = optionalEmployee.get();
            employeeRepository.delete(employee);
        }
        else {
             throw new RuntimeException("Employee does not exist");
        }
    }
}
