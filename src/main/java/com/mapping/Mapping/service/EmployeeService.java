package com.mapping.Mapping.service;

import com.mapping.Mapping.request.dto.EmployeeRequest;
import com.mapping.Mapping.response.dto.EmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    public void safeEmployee(EmployeeRequest employeeRequest);
    public boolean existsById(long id);

    public List<EmployeeResponse> getAllEmployee();

    public EmployeeResponse getEmployee(Long id);

    public void deleteEmployee(long id);
}
