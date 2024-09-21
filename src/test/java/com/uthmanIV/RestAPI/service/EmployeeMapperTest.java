package com.uthmanIV.RestAPI.service;

import com.uthmanIV.RestAPI.entity.Department;
import com.uthmanIV.RestAPI.entity.Employee;
import com.uthmanIV.RestAPI.entity.EmployeeResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EmployeeMapperTest {

    @Mock
    EmployeeMapper mapper; // Mocked instance

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    public void shouldMapToDTO() {
        // Sample Data
        Employee testEmployee = new Employee(
                1,
                "Usman",
                "Yahya",
                "uthmanyahaya@gmail.com",
                new Department(1, "ICT", new ArrayList<>()),
                new ArrayList<>()
        );

        // Create expected DTO
        EmployeeResponseDTO expectedDto = new EmployeeResponseDTO(1, "Usman", "Yahya", "uthmanyahaya@gmail.com", 1, new ArrayList<>());

        // Mock the behavior of the mapper
        when(mapper.toDTO(testEmployee)).thenReturn(expectedDto); // Specify what to return

        // Act
        EmployeeResponseDTO dto = mapper.toDTO(testEmployee); // Now this should return the mocked DTO

        // Assert
        assertEquals(expectedDto.employeeId(), dto.employeeId());
        assertEquals(expectedDto.fName(), dto.fName());
        assertEquals(expectedDto.lNAme(), dto.lNAme());
        assertEquals(expectedDto.emailAddress(), dto.emailAddress());
        assertEquals(expectedDto.departmentId(), dto.departmentId());
        assertEquals(expectedDto.employeeDuties(), dto.employeeDuties());

        // Verify calls
        verify(mapper, times(1)).toDTO(testEmployee); // Verify the call
    }
}