package com.uthmanIV.RestAPI.DAO;

import com.uthmanIV.RestAPI.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDAO {

    List<Employee> findALl();
    Employee findById(int id);
    void addEmployee(Employee e);
    void updateEmployee();
    void delete();
}
