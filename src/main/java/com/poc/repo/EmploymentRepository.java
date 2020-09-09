package com.poc.repo;


import com.poc.domain.Employee;
import com.poc.domain.Employment;
import com.poc.dto.EmploymentDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EmploymentRepository extends CrudRepository<Employment, Long> {

    Set<EmploymentDTO> findByEmployeeOrderByStartDesc(Employee employee);

    Employment findByEmployeeAndEndIsNull(Employee employee);
}
