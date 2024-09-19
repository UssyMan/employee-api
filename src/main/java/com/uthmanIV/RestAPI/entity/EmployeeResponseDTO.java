package com.uthmanIV.RestAPI.entity;

import java.util.List;

public record EmployeeResponseDTO(
        long employeeId,
        String fName,
        String lNAme,
        String emailAddress,
        Integer departmentId,
        List<Duties> employeeDuties
){


}
