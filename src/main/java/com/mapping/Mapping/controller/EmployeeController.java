package com.mapping.Mapping.controller;

import com.mapping.Mapping.common.response.BaseResponse;
import com.mapping.Mapping.common.response.ContentResponse;
import com.mapping.Mapping.request.dto.EmployeeRequest;
import com.mapping.Mapping.rest.enums.RequestStatus;
import com.mapping.Mapping.service.AddressService;
import com.mapping.Mapping.service.EmployeeService;
import com.mapping.Mapping.utils.Constants;
import com.mapping.Mapping.utils.EndpointURI;
import com.mapping.Mapping.utils.ValidationResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ValidationResponseCode validationResponseCode;
    @Autowired
    private AddressService addressService;

    @PostMapping(value = EndpointURI.EMPLOYEE)
    public ResponseEntity<Object> safeEmployee(@RequestBody EmployeeRequest employeeRequest)
    {
        if(!addressService.existsById(employeeRequest.getAddressId()))
        {
            return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                    validationResponseCode.getAddressNotExists(),
                    validationResponseCode.getAddressNotExistsMessage()));
        }
        employeeService.safeEmployee(employeeRequest);
        return ResponseEntity.ok(new BaseResponse(RequestStatus.SUCCESS.getStatus(),
                validationResponseCode.getCommonSuccessCode(),
                validationResponseCode.getEmployeeSaveSuccessMessage()));
    }
    @PutMapping(value = EndpointURI.EMPLOYEE)
    public ResponseEntity<Object> updateEmployee(@RequestBody EmployeeRequest employeeRequest)
    {
        if(!employeeService.existsById(employeeRequest.getId()))
        {
            return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                    validationResponseCode.getEmployeeNotExists(),
                    validationResponseCode.getEmployeeNotExistsMessage()));
        }
        if(!addressService.existsById(employeeRequest.getAddressId()))
        {
            return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                    validationResponseCode.getAddressNotExists(),
                    validationResponseCode.getAddressNotExistsMessage()));
        }

        employeeService.safeEmployee(employeeRequest);
        return ResponseEntity.ok(new BaseResponse(RequestStatus.SUCCESS.getStatus(),
                validationResponseCode.getCommonSuccessCode(),
                validationResponseCode.getEmployeeSaveSuccessMessage()));
    }

    @GetMapping(value = EndpointURI.EMPLOYEE)
    public ResponseEntity<Object> getALlEmployee()
    {
        return ResponseEntity.ok(new ContentResponse<>(
                Constants.EMPLOYEE,
                employeeService.getAllEmployee(),
                RequestStatus.SUCCESS.getStatus(),
                validationResponseCode.getCommonSuccessCode(),
                validationResponseCode.getEmployeeGetAllSuccessMessage()));
    }
    @GetMapping(value = EndpointURI.EMPLOYEE_BY_ID)
    public ResponseEntity<Object> getEmployeeById(@PathVariable Long id)
    {
        if(!employeeService.existsById(id))
        {
            return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                    validationResponseCode.getEmployeeNotExists(),
                    validationResponseCode.getEmployeeNotExistsMessage()));
        }
        return ResponseEntity.ok(new ContentResponse<>(Constants.EMPLOYEE,employeeService.getEmployee(id),RequestStatus.SUCCESS.getStatus(),
                validationResponseCode.getCommonSuccessCode(),
                validationResponseCode.getEmployeeGetSuccessMessage()));
    }
    @DeleteMapping(value = EndpointURI.EMPLOYEE_BY_ID)
    public ResponseEntity<Object> deleteEmployee(@PathVariable Long id)
    {
        if(!employeeService.existsById(id))
        {
            return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                    validationResponseCode.getEmployeeNotExists(),
                    validationResponseCode.getEmployeeNotExistsMessage()));
        }
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok(new BaseResponse(RequestStatus.SUCCESS.getStatus(),
                validationResponseCode.getCommonSuccessCode(),
                validationResponseCode.getEmployeeDeleteSuccessMessage()));
    }

}
