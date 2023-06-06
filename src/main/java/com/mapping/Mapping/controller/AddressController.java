package com.mapping.Mapping.controller;

import com.mapping.Mapping.common.response.BaseResponse;
import com.mapping.Mapping.common.response.ContentResponse;
import com.mapping.Mapping.request.dto.AddressRequest;
import com.mapping.Mapping.rest.enums.RequestStatus;
import com.mapping.Mapping.service.AddressService;
import com.mapping.Mapping.utils.Constants;
import com.mapping.Mapping.utils.EndpointURI;
import com.mapping.Mapping.utils.ValidationResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AddressController {
    @Autowired
    private AddressService addressService;

    @Autowired
    private ValidationResponseCode validationResponseCode;
    @PostMapping(value = EndpointURI.ADDRESS)
    public ResponseEntity<Object> createAddress(@RequestBody AddressRequest addressRequest)
    {
        if(addressService.existsByCity(addressRequest.getCity()))
        {
            return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                    validationResponseCode.getAddressAlReadyExits(),
                    validationResponseCode.getAddressAllReadyExistsMessage()));
        }
        addressService.createAddress(addressRequest);
        return ResponseEntity.ok(new BaseResponse(RequestStatus.SUCCESS.getStatus(),
                validationResponseCode.getCommonSuccessCode(),validationResponseCode.getAddressSaveSuccessMessage()));
    }
    @GetMapping(value = EndpointURI.ADDRESS)
    public ResponseEntity<Object> getAllAddress()
    {
        if(addressService.getAllAddress()==null)
        {
            return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                    validationResponseCode.getAddressNotExists(),validationResponseCode.getAddressNotFound()));
        }
        return ResponseEntity.ok(new ContentResponse<>(Constants.ADDRESSES,addressService.getAllAddress(),RequestStatus.SUCCESS.getStatus(),
                validationResponseCode.getCommonSuccessCode(),validationResponseCode.getGetAddressSuccessMessage()));
    }
    @GetMapping(value = EndpointURI.ADDRESS_BY_ID)
    public ResponseEntity<Object> getAddressById(@PathVariable Long id)
    {
        if (!addressService.existsById(id))
        {
            return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                    validationResponseCode.getAddressNotExists(),validationResponseCode.getAddressNotExistsMessage()));
        }
        return ResponseEntity.ok(new ContentResponse<>(Constants.ADDRESS,addressService.getByAddressId(id),RequestStatus.SUCCESS.getStatus(),
                validationResponseCode.getCommonSuccessCode(),validationResponseCode.getGetAddressSuccessMessage()));
    }
    @DeleteMapping(value = EndpointURI.ADDRESS_BY_ID)
    public ResponseEntity<Object> deleteAddressById(@PathVariable Long id)
    {
        if (!addressService.existsById(id))
        {
            return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                    validationResponseCode.getAddressNotExists(),validationResponseCode.getAddressNotExistsMessage()));
        }
        addressService.deleteAddress(id);
        return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),validationResponseCode.getCommonSuccessCode() ,
                validationResponseCode.getAddressDeleteSuccessMessage()));
    }
    @PutMapping(value = EndpointURI.ADDRESS)
    public ResponseEntity<Object> updateAddress(@RequestBody AddressRequest addressRequest)
    {
        if(!addressService.existsById(addressRequest.getId()))
        {
            return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                    validationResponseCode.getAddressNotExists(),validationResponseCode.getAddressNotExistsMessage()));
        }
        if(addressService.exitsByCityIgnoreCaseIdNot(addressRequest.getCity(),addressRequest.getId()))
        {

            return  ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),validationResponseCode.getAddressAlReadyExits(),
                    validationResponseCode.getAddressAllReadyExistsMessage()));
        }
        addressService.createAddress(addressRequest);
        return ResponseEntity.ok(new BaseResponse(RequestStatus.SUCCESS.getStatus(),
                validationResponseCode.getCommonSuccessCode(),validationResponseCode.getAddressSaveSuccessMessage()));
    }
}
