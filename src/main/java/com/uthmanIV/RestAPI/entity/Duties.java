package com.uthmanIV.RestAPI.entity;

import jakarta.persistence.*;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import java.util.List;

@Entity
@Table(name = "duties")
public class Duties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int hours;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "duties-id"),
            inverseJoinColumns = @JoinColumn(name = "employee-id")
    )
    private List<Employee> employees;


}
