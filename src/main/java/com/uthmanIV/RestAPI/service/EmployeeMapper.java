package com.uthmanIV.RestAPI.service;

import com.uthmanIV.RestAPI.entity.Employee;
import com.uthmanIV.RestAPI.entity.EmployeeRequestDTO;
import com.uthmanIV.RestAPI.entity.EmployeeResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {
    public Employee toEmployee(EmployeeRequestDTO dto){
        final var employeeBuilder = Employee.builder()
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .email(dto.email());

        return employeeBuilder.build();
    }
    public EmployeeResponseDTO toDTO(Employee employee){
        Integer departmentId = (employee.getDepartment() != null) ? employee.getDepartment().getId() : null;

        return new EmployeeResponseDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                departmentId,
                employee.getDuties()
        );
    }

}
