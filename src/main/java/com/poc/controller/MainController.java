package com.poc.controller;


import com.poc.domain.ChangeJobRequest;
import com.poc.domain.Department;
import com.poc.domain.Employee;
import com.poc.domain.Organization;
import com.poc.repo.DepartmentRepository;
import com.poc.repo.EmployeeRepository;
import com.poc.repo.OrganizationRepository;
import com.poc.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    Service service;

    @GetMapping("/organization")
    public Iterable<Organization> findAllOrganizations() {
        return organizationRepository.findAll();
    }

    @GetMapping("/employee")
    public Iterable<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/organization/name/{name}")
    public Optional<Organization> findOrganization(@PathVariable String name) {
        return organizationRepository.findByName(name);
    }

    @GetMapping("/organization/{id}")
    public Optional<Organization> findOrganizationById(@PathVariable Long id) {
        return organizationRepository.findById(id);
    }

    @PostMapping("/add-organization")
    public Organization addOrganization(@RequestBody Organization organization) {
        return organizationRepository.save(organization);
    }

    @PostMapping("/change-job")
    public void changeJob(@RequestBody ChangeJobRequest request) {
        service.changeJob(request.getEmployeeId(), request.getTargetDepartmentId());
    }

    @PostMapping("/employee/{departmentId}")
    public void addNewEmployee(@RequestBody Employee employee, @PathVariable Long departmentId) {
        service.hireEmployee(employee, departmentId);
    }

    @PostMapping("/departments/{organizationId}")
    public Department addNewDepartment(@RequestBody Department department, @PathVariable Long organizationId) {
        organizationRepository.findById(organizationId).ifPresent(organization -> {
            department.setOrganization(organization);
            departmentRepository.save(department);
        });
        return department;
    }
}
