package com.example.employermanagementsystem.employee;

import com.example.employermanagementsystem.user.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table()
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String email;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Seniority seniority;

    private String accountNumber;
    private String hourlyWage;
}
