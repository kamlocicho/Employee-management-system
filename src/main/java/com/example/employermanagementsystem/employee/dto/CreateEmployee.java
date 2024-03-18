package com.example.employermanagementsystem.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployee {
    private String email;
    private String firstName;
    private String lastName;
    private String seniority;
    private String accountNumber;
    private String hourlyWage;
}
