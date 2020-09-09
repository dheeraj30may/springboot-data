package com.poc;

import com.poc.domain.Department;
import com.poc.domain.Employee;
import com.poc.domain.Organization;
import com.poc.repo.DepartmentRepository;
import com.poc.repo.EmployeeRepository;
import com.poc.repo.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringbootDataApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDataApplication.class, args);
    }

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    OrganizationRepository organizationRepository;

    @Override
    public void run(String... args) {

        Organization accenture = new Organization("Accenture", "Hartford");
        Organization organizationAccentureSaved = organizationRepository.save(accenture);

        Department techdepartment = new Department("Technology");
        techdepartment.setOrganization(accenture);
        Department departmentSaved = departmentRepository.save(techdepartment);

        Employee dheeraj = new Employee("Dheeraj", 30, "Developer", 50000);
        dheeraj.setOrganization(organizationAccentureSaved);
        dheeraj.setDepartment(departmentSaved);

        Employee sandeep = new Employee("Sandeep", 30, "Developer", 60000);
        dheeraj.setOrganization(organizationAccentureSaved);
        dheeraj.setDepartment(departmentSaved);

        Employee saurabh = new Employee("Saurabh", 50, "Developer", 50000);
        dheeraj.setOrganization(organizationAccentureSaved);
        dheeraj.setDepartment(departmentSaved);


        Department hrDepartment = new Department("HR");
        hrDepartment.setOrganization(accenture);
        Department hrDepSAved = departmentRepository.save(hrDepartment);

        Employee sunil = new Employee("Sunil", 30, "Developer", 40000);
        dheeraj.setOrganization(organizationAccentureSaved);
        dheeraj.setDepartment(hrDepSAved);

        Employee arun = new Employee("arun", 40, "Developer", 40000);
        dheeraj.setOrganization(organizationAccentureSaved);
        dheeraj.setDepartment(hrDepSAved);

        employeeRepository.saveAll(Arrays.asList(dheeraj, sandeep, saurabh, sunil, arun));

    }
}
