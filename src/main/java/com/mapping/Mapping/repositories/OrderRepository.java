package com.mapping.Mapping.repositories;

import com.mapping.Mapping.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
