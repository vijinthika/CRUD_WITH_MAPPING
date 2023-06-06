package com.mapping.Mapping.service.Impl;

import com.mapping.Mapping.entities.Address;
import com.mapping.Mapping.repositories.AddressRepository;
import com.mapping.Mapping.request.dto.AddressRequest;
import com.mapping.Mapping.response.dto.AddressResponse;
import com.mapping.Mapping.service.AddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public void createAddress(AddressRequest addressRequest) {
        Address address=new Address();
        BeanUtils.copyProperties(addressRequest,address);
        addressRepository.save(address);

    }

    @Override
    public boolean existsByCity(String city) {
        return addressRepository.existsByCityIgnoreCase(city);
    }

    @Override
    public boolean existsById(Long id) {
        return addressRepository.existsById(id);
    }

    @Override
    public List<AddressResponse> getAllAddress() {
        List<AddressResponse> addressResponseList=new ArrayList<>();
        List<Address> addressList=addressRepository.findAll();
        for (Address address:addressList
             ) {
            AddressResponse addressResponse=new AddressResponse();
            BeanUtils.copyProperties(address,addressResponse);
            addressResponseList.add(addressResponse);
        }
        return addressResponseList;
    }

    @Override
    public AddressResponse getByAddressId(Long id) {
        AddressResponse addressResponse=new AddressResponse();
        Address address=addressRepository.findById(id).get();
        BeanUtils.copyProperties(address,addressResponse);
        return addressResponse;
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public boolean exitsByCityIgnoreCaseIdNot(String city, Long id) {
        return addressRepository.existsByCityIgnoreCaseAndIdNot(city,id);
    }


}
