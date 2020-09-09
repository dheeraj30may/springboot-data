package com.poc.controller;

import com.poc.domain.Employee;
import com.poc.dto.EmploymentDTO;
import com.poc.repo.EmployeeRepository;
import com.poc.repo.EmploymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("employments")
public class EmploymentController {
   @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmploymentRepository repository;

    @GetMapping("/employee/{employeeId}")
    public Set<EmploymentDTO> findByEmployee(Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        return repository.findByEmployeeOrderByStartDesc(employee.get());
    }
}
