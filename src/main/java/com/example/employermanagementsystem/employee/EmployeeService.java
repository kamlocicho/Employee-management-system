package com.example.employermanagementsystem.employee;

import com.example.employermanagementsystem.config.CustomException;
import com.example.employermanagementsystem.employee.dto.CreateEmployee;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }


    public Employee createNewEmployee(CreateEmployee createEmployee) {
        Employee employee = Employee
                .builder()
                .accountNumber(createEmployee.getAccountNumber())
                .firstName(createEmployee.getFirstName())
                .lastName(createEmployee.getLastName())
                .seniority(Seniority.valueOf(createEmployee.getSeniority().toUpperCase()))
                .hourlyWage(createEmployee.getHourlyWage())
                .email(createEmployee.getEmail())
                .build();

        employeeRepository.save(employee);

        return employee;
    }

    public Employee updateEmployee(Employee employee, CreateEmployee createEmployee) {
        employee.setAccountNumber(createEmployee.getAccountNumber());
        employee.setFirstName(createEmployee.getFirstName());
        employee.setLastName(createEmployee.getLastName());
        employee.setHourlyWage(createEmployee.getHourlyWage());
        employee.setSeniority(Seniority.valueOf(createEmployee.getSeniority().toUpperCase()));

        employeeRepository.save(employee);

        return employee;
    }

    public Employee deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);

        return employee;
    }
}
