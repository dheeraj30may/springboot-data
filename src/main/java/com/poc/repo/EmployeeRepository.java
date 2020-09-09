package com.poc.repo;



import com.poc.domain.Employee;
import com.poc.domain.Organization;
import com.poc.dto.EmployeeDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Set<EmployeeDTO> findBySalaryGreaterThan(int salary);

    Set<EmployeeDTO> findByOrganization(Organization organization);

    int findAvgSalaryByAge(int age);

    int findAvgSalaryByOrganization(Organization organization);

}
