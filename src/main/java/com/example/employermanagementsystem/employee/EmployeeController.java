package com.example.employermanagementsystem.employee;

import com.example.employermanagementsystem.config.CustomException;
import com.example.employermanagementsystem.employee.dto.CreateEmployee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{email}")
    public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable("email") String email) throws CustomException {
        Optional<Employee> employee = employeeService.getEmployeeByEmail(email);

        if(employee.isEmpty()){
            throw new CustomException("NOT_FOUND", "Employee with this email does not exist.", 404);
        }

        return ResponseEntity.ok(employee.get());
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Employee> createNewEmployee(@RequestBody CreateEmployee createEmployee) throws CustomException {
        Optional<Employee> employee = employeeService.getEmployeeByEmail(createEmployee.getEmail());

        if(employee.isPresent()) {
            throw new CustomException("BAD_REQUEST", "Employee with this email already exists.", 400);
        }

        Employee newEmployee = employeeService.createNewEmployee(createEmployee);
        return ResponseEntity.ok(newEmployee);
    }

    @PutMapping("/{email}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("email") String email, @RequestBody CreateEmployee createEmployee) throws CustomException {
        Optional<Employee> employee = employeeService.getEmployeeByEmail(email);

        if(employee.isEmpty()) {
            throw new CustomException("NOT_FOUND", "Employee with this email does not exist.", 404);
        }

        Employee updatedEmployee = employeeService.updateEmployee(employee.get(), createEmployee);
        return ResponseEntity.ok(updatedEmployee);
    }
}
