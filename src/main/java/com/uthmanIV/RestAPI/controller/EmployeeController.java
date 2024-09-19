package com.uthmanIV.RestAPI.controller;

import com.uthmanIV.RestAPI.entity.Employee;
import com.uthmanIV.RestAPI.entity.EmployeeRequestDTO;
import com.uthmanIV.RestAPI.entity.EmployeeResponseDTO;
import com.uthmanIV.RestAPI.service.EmployeeMapper;
import com.uthmanIV.RestAPI.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<EmployeeResponseDTO> getAllEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("{id}")
    public EmployeeResponseDTO findById(@PathVariable int id){
        return employeeService.findById(id);
    }

    @PostMapping
    public EmployeeResponseDTO addEmployee(@RequestBody EmployeeRequestDTO employee){
        return employeeService.addEmployee(employee);
    }

    @PutMapping
    public EmployeeResponseDTO updateEmployee(@RequestBody EmployeeRequestDTO employee){
        return employeeService.updateEmployee(employee);
    }
    @DeleteMapping("{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId){
        employeeService.delete(employeeId);
    }
}
