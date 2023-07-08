package com.EmployeeManagementSystem.EMS.Services;

import com.EmployeeManagementSystem.EMS.Models.Employee;
import com.EmployeeManagementSystem.EMS.Repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService  {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Employee createEmployee(Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeUsingId(Long id) {
        return employeeRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No employee found"));
    }

    public Employee updateEmployee(Long id, Employee employeeReq) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            employee.setFirstname(employeeReq.getFirstname());
            employee.setLastname(employeeReq.getLastname());
            employee.setEmail(employeeReq.getEmail());
            employee.setPassword(passwordEncoder.encode(employeeReq.getPassword()));
            return employeeRepository.save(employee);
        }else{
            throw new EntityNotFoundException("Employee not found with id " + id);
        }
    }

    //delete employee using specific ID
    public ResponseEntity<Void> deleteEmployee(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            employeeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}
