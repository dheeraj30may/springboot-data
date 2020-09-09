package com.poc.controller;

import com.poc.domain.Organization;
import com.poc.repo.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("organizations")
public class OrganizationController {
    @Autowired
    OrganizationRepository repository;

    @PostMapping
    public Long addOrganization(@RequestBody Organization organization) {
        Organization organization1 = repository.save(organization);
        return organization1.getId();
    }

    @GetMapping("/name/{name}")
    public Optional<Organization> findOrganization(String name) {
        return repository.findByName(name);
    }
}
