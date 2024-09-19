package com.uthmanIV.RestAPI.service;

import com.uthmanIV.RestAPI.entity.Employee;
import com.uthmanIV.RestAPI.entity.EmployeeRequestDTO;
import com.uthmanIV.RestAPI.entity.EmployeeResponseDTO;
import com.uthmanIV.RestAPI.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper mapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper mapper){
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    @Override
    public List<EmployeeResponseDTO> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponseDTO findById(int id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()){
            return mapper.toDTO(employeeOptional.get());
        }
        else{
            throw new RuntimeException("Employee not found with id -" + id);
        }
    }

    @Override
    public EmployeeResponseDTO addEmployee(EmployeeRequestDTO employee) {
        Employee e = mapper.toEmployee(employee);
        Optional<Employee> optionalEmployee = employeeRepository.findByEmail(e.getEmail());
        if (optionalEmployee.isPresent()){
            throw new RuntimeException("Employee Exist with email:" + e.getEmail());
        }
        else{
            employeeRepository.save(e);
            return mapper.toDTO(e);
        }

    }

    @Override
    public EmployeeResponseDTO updateEmployee(EmployeeRequestDTO e) {
        Employee employee = mapper.toEmployee(e);
        Optional<Employee> optionalEmployee = employeeRepository.findByEmail(employee.getEmail());
         if (optionalEmployee.isPresent()){
             employeeRepository.save(employee);
             return mapper.toDTO(employee);
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
