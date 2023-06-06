package com.mapping.Mapping.service;

import com.mapping.Mapping.request.dto.AddressRequest;
import com.mapping.Mapping.response.dto.AddressResponse;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AddressService {
    public void createAddress(AddressRequest addressRequest);

    public boolean existsByCity(String city);
    public boolean existsById(Long id);

    public List<AddressResponse> getAllAddress();

    public AddressResponse getByAddressId(Long id);

    public void deleteAddress(Long id);

    public boolean exitsByCityIgnoreCaseIdNot(String city,Long id);

}
