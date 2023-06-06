package com.mapping.Mapping.service;

import com.mapping.Mapping.request.dto.CustomerRequest;
import com.mapping.Mapping.response.dto.CustomerResponse;

import java.util.List;

public interface CustomerService {
    public void safeCustomer(CustomerRequest customerRequest);

    public List<CustomerResponse> getALlCustomer();

    public CustomerResponse getCustomerById(Long id);



    public void deleteCustomer(Long id);

    public boolean existsById(Long id);
}
