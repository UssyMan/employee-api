package com.uthmanIV.RestAPI.service;

import com.uthmanIV.RestAPI.entity.Department;
import com.uthmanIV.RestAPI.entity.Employee;
import com.uthmanIV.RestAPI.entity.EmployeeResponseDTO;
import com.uthmanIV.RestAPI.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EmployeeServiceImplTest {

    @InjectMocks //injecting the dependencies mocked
    private EmployeeServiceImpl employeeService;

    //its dependencies being mocked
    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeMapper employeeMapper;

    @BeforeEach
    void setUp(){
        //opening the mocks for this test instance?
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
    }
    public Employee createEmployee(Integer id){
        return new Employee(
                id,
                "Usman",
                "Yahaya",
                "uthmanIv@gmai.com",
                new Department(2,"CS",new ArrayList<>()),
                new ArrayList<>()
        );
    }
    public EmployeeResponseDTO createDto(Integer id){
        return new EmployeeResponseDTO(
                id,
                "Usman",
                "Yahaya",
                "uthmanIv@gmail.com",
                2,
                new ArrayList<>()

        );
    }
    @Test
    void findById_success() {
        //Given
        Employee sampleEmployee = createEmployee(2);
        EmployeeResponseDTO dto = createDto(2);

        //Mock calls
        when(employeeRepository.findById(2)).thenReturn(Optional.of(sampleEmployee));
        when(employeeMapper.toDTO(sampleEmployee)).thenReturn(dto);

        //Act (this is when method calls are made)
        EmployeeResponseDTO testResult = employeeService.findById(2);

        //Assertions
        /*
        assertAll("Checking EMployeeResponseDTO values",
                ()-> assertNotNull(testResult,"result should not be null"),
                ()-> assertEquals(2,testResult.employeeId())
                // and the rest
        );
         */
        assertNotNull(testResult);
        assertArrayEquals(
                new Object[]{
                        2,
                        "Usman",
                        "Yahaya",
                        "uthmanIv@gmail.com",
                         new Department(2,"CS",new ArrayList<>()),
                         new ArrayList<>()
                },
                new Object[]{
                        testResult.employeeId(),
                        testResult.fName(),
                        testResult.lNAme(),
                        testResult.emailAddress(),
                        testResult.departmentId(),
                        testResult.employeeDuties()
                }, "Values should match");
    }
    @Test //when the employee not found
    void findById_failure(){

    }
}