package com.poc.controller;

import com.poc.domain.ChangeJobRequest;
import com.poc.domain.Employee;
import com.poc.domain.Organization;
import com.poc.dto.EmployeeDTO;
import com.poc.repo.EmployeeRepository;
import com.poc.repo.OrganizationRepository;
import com.poc.service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    @Autowired
    EmployeeRepository repository;
    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    Service service;

    @GetMapping("/salary/{salary}")
    public Set<EmployeeDTO> findEmployeesBySalary(int salary) {
        return repository.findBySalaryGreaterThan(salary);
    }

    @GetMapping("/organization/{organizationId}")
    public Set<EmployeeDTO> findEmployeesByOrganization(Long organizationId) {
        Optional<Organization> organization = organizationRepository.findById(organizationId);
        return repository.findByOrganization(organization.get());
    }

    @GetMapping("/salary-avg/age/{age}")
    public int findAvgSalaryByAge(int age) {
        return repository.findAvgSalaryByAge(age);
    }

    @GetMapping("/salary-avg/organization/{organizationId}")
    public int findAvgSalaryByAge(Long organizationId) {
        Optional<Organization> organization = organizationRepository.findById(organizationId);
        return repository.findAvgSalaryByOrganization(organization.get());
    }

    @PostMapping("/{departmentId}")
    public void addNewEmployee(@RequestBody Employee employee, Long departmentId) {
        service.hireEmployee(employee, departmentId);
    }

    @PutMapping("/change-job")
    public void changeJob(@RequestBody  ChangeJobRequest request) {
        service.changeJob(request.getEmployeeId(), request.getTargetDepartmentId());
    }
}
