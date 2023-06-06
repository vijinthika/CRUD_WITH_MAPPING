package com.mapping.Mapping.repositories;

import com.mapping.Mapping.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
