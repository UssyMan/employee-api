package com.uthmanIV.RestAPI.service;

import com.uthmanIV.RestAPI.entity.Employee;
import com.uthmanIV.RestAPI.entity.EmployeeRequestDTO;
import com.uthmanIV.RestAPI.entity.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseDTO> findAll();
    EmployeeResponseDTO findById(int id);
    EmployeeResponseDTO addEmployee(EmployeeRequestDTO e);
    EmployeeResponseDTO updateEmployee(EmployeeRequestDTO e);
    void delete(int id);
}
