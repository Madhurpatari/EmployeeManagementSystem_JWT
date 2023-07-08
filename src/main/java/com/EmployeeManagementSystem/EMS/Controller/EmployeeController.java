package com.EmployeeManagementSystem.EMS.Controller;

import com.EmployeeManagementSystem.EMS.Models.Employee;
import com.EmployeeManagementSystem.EMS.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add-employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }



    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeUsingId(id);
    }

    @GetMapping("/employees/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employeeList = employeeService.getAllEmployee();
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id , @RequestBody Employee employeeReq){
        return employeeService.updateEmployee(id, employeeReq);
    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }
}
