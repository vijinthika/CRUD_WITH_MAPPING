package com.mapping.Mapping.service.Impl;

import com.mapping.Mapping.entities.Address;
import com.mapping.Mapping.entities.Customer;
import com.mapping.Mapping.repositories.CustomerRepository;
import com.mapping.Mapping.request.dto.CustomerRequest;
import com.mapping.Mapping.response.dto.CustomerResponse;
import com.mapping.Mapping.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public void safeCustomer(CustomerRequest customerRequest) {
        Customer customer=new Customer();
        Address address=new Address();
        address.setId(customerRequest.getAddress_Id());
        customer.setAddress(address);
        BeanUtils.copyProperties(customerRequest,customer);

        customerRepository.save(customer);
    }

    @Override
    public List<CustomerResponse> getALlCustomer() {
        List<CustomerResponse> customerResponseList=new ArrayList<>();
        List<Customer> customerList=customerRepository.findAll();
        for (Customer customer:customerList
             ) {
            CustomerResponse customerResponse=new CustomerResponse();
            customerResponse.setAddressCity(customer.getAddress().getCity());
            customerResponse.setAddressId(customer.getAddress().getId());
            BeanUtils.copyProperties(customer,customerResponse);
            customerResponseList.add(customerResponse);
        }
        return customerResponseList;
    }

    @Override
    public CustomerResponse getCustomerById(Long id) {
        CustomerResponse customerResponse=new CustomerResponse();
        Customer customer=customerRepository.findById(id).get();
        customerResponse.setAddressId(customer.getAddress().getId());
        customerResponse.setAddressCity(customer.getAddress().getCity());
        return customerResponse;
    }

    @Override
    public boolean existById(Long id) {
        return customerRepository.existsById(id);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.existsById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return customerRepository.existsById(id);
    }

}
