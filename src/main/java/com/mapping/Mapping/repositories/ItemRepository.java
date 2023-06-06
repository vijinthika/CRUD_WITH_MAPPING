package com.mapping.Mapping.repositories;

import com.mapping.Mapping.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
