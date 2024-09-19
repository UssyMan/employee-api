package com.uthmanIV.RestAPI.service;

import com.uthmanIV.RestAPI.entity.Department;
import com.uthmanIV.RestAPI.entity.Employee;
import com.uthmanIV.RestAPI.entity.EmployeeResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeMapperTest  {

    EmployeeMapper mapper;
    @BeforeEach
    void setMapper(){
        mapper = new EmployeeMapper();
    }

    @Test
    public void shouldMapToDTO(){
        Employee testEmployee = new Employee(
                1,
                "Usman",
                "Yahya",
                "uthmanyahaya@gmail.com",
                new Department(1,"ICT",new ArrayList<>()),
                new ArrayList<>());
        EmployeeResponseDTO dto = mapper.toDTO(testEmployee);

        assertEquals(dto.employeeId(),testEmployee.getId());
        assertEquals(dto.fName(),testEmployee.getFirstName());
        assertEquals(dto.lNAme(),testEmployee.getLastName());
        assertEquals(dto.emailAddress(),testEmployee.getEmail());
        assertEquals(dto.departmentId(),testEmployee.getDepartment().getId());
        assertEquals(dto.employeeDuties(),testEmployee.getDuties());
    }
}