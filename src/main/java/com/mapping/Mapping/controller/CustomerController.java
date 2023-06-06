package com.mapping.Mapping.controller;

import com.mapping.Mapping.common.response.BaseResponse;
import com.mapping.Mapping.common.response.ContentResponse;
import com.mapping.Mapping.request.dto.CustomerRequest;
import com.mapping.Mapping.rest.enums.RequestStatus;
import com.mapping.Mapping.service.AddressService;
import com.mapping.Mapping.service.CustomerService;
import com.mapping.Mapping.utils.Constants;
import com.mapping.Mapping.utils.EndpointURI;
import com.mapping.Mapping.utils.ValidationResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private ValidationResponseCode validationResponseCode;

    @PostMapping(value = EndpointURI.CUSTOMER)
    public ResponseEntity<Object> safeCustomer(@RequestBody CustomerRequest customerRequest)
    {
        if(!addressService.existsById(customerRequest.getAddress_Id()))
        {
            return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                    validationResponseCode.getAddressNotExists(),
                    validationResponseCode.getAddressNotExistsMessage()));
        }
        customerService.safeCustomer(customerRequest);
        return ResponseEntity.ok(new BaseResponse(RequestStatus.SUCCESS.getStatus(),
                validationResponseCode.getCommonSuccessCode(),
                validationResponseCode.getCustomerSaveSuccessMessage()));
    }
    @GetMapping(value = EndpointURI.CUSTOMER)
    public ResponseEntity<Object> getAllCustomer()
    {
        return ResponseEntity.ok(new ContentResponse<>(Constants.CUSTOMER,customerService.getALlCustomer(),
                RequestStatus.SUCCESS.getStatus(),
                validationResponseCode.getCommonSuccessCode(),
                validationResponseCode.getCustomerGetAllSuccessMessage()));
    }
    @GetMapping(value = EndpointURI.CUSTOMER_BY_ID)
    public ResponseEntity<Object> getCustomerById(Long id)
    {
        if(!customerService.existById(id))
        {
            return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                    validationResponseCode.getCustomerNotExists(),
                    validationResponseCode.getCustomerNotExistsMessage()));
        }
        return ResponseEntity.ok(new ContentResponse<>(
                Constants.CUSTOMERS,
                customerService.getCustomerById(id),
                RequestStatus.SUCCESS.getStatus(),
                validationResponseCode.getCommonSuccessCode(),
                validationResponseCode.getCustomerGetSuccessMessage()));
    }
    @DeleteMapping(value = EndpointURI.CUSTOMER_BY_ID)
    public ResponseEntity<Object> deleteCustomer(@PathVariable Long id)
    {
        return ResponseEntity.ok(new BaseResponse(RequestStatus.SUCCESS.getStatus(),
                validationResponseCode.getCommonSuccessCode(),
                validationResponseCode.getCustomerDeleteSuccessMessage()));
    }
    @PostMapping(value = EndpointURI.CUSTOMER)
    public ResponseEntity<Object> updateCustomer(@RequestBody CustomerRequest customerRequest)
    {
        if(!customerService.existsById(customerRequest.getId()))
        {

        }
        if(!addressService.existsById(customerRequest.getAddress_Id()))
        {
            return ResponseEntity.ok(new )
        }
        customerService.safeCustomer(customerRequest);
        return ResponseEntity.ok(new BaseResponse(RequestStatus.SUCCESS.getStatus(),
                validationResponseCode.getCommonSuccessCode(),
                validationResponseCode.getCustomerSaveSuccessMessage()));
    }

}
