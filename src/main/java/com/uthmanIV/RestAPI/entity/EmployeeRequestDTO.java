package com.uthmanIV.RestAPI.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record EmployeeRequestDTO(
        @NotBlank(message = "first name must not be blank")
        String firstName,

        @NotBlank(message = "last name must not be blank")
        String lastName,

        @NotBlank(message = "email address must be provided")
        String email
) {

}
