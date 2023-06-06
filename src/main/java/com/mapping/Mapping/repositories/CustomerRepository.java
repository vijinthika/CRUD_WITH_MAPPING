package com.mapping.Mapping.repositories;

import com.mapping.Mapping.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    public boolean existsById(Long id);
}
