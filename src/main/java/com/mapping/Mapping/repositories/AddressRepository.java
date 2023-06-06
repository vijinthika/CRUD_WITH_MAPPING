package com.mapping.Mapping.repositories;

import com.mapping.Mapping.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {

    public boolean existsByCityIgnoreCase(String city);

    public boolean existsByCityIgnoreCaseAndIdNot(String city,Long id);
}
