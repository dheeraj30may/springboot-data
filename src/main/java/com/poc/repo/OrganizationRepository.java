package com.poc.repo;

import com.poc.domain.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.JoinColumn;
import java.util.Optional;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long> {

   // @Join(value = "departments", type = Join.Type.LEFT_FETCH)
   // @Join(value = "employees", type = Join.Type.LEFT_FETCH)
   @JoinColumn(name="departments", nullable=true)
   @JoinColumn(name="employees", nullable=true)
    Optional<Organization> findByName(String name);
}
