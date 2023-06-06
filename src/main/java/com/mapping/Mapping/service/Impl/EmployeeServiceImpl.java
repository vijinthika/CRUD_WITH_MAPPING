package com.mapping.Mapping.service.Impl;

import com.mapping.Mapping.entities.Address;
import com.mapping.Mapping.entities.Employee;
import com.mapping.Mapping.repositories.EmployeeRepository;
import com.mapping.Mapping.request.dto.EmployeeRequest;
import com.mapping.Mapping.response.dto.EmployeeResponse;
import com.mapping.Mapping.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public void safeEmployee(EmployeeRequest employeeRequest) {
        Employee employee=new Employee();
        Address address=new Address();
        address.setId(employeeRequest.getAddressId());
        employee.setAddress(address);
        BeanUtils.copyProperties(employeeRequest,employee);
        employeeRepository.save(employee);
    }

    @Override
    public boolean existsById(long id) {
        return employeeRepository.existsById(id);
    }

    @Override
    public List<EmployeeResponse> getAllEmployee() {
        List<EmployeeResponse> employeeResponseList=new ArrayList<>();
        List<Employee> employeeList=employeeRepository.findAll();

        for (Employee employee:employeeList
             ) {
            EmployeeResponse employeeResponse=new EmployeeResponse();
            employeeResponse.setAddress_city(employee.getAddress().getCity());
            BeanUtils.copyProperties(employee,employeeResponse);
            employeeResponseList.add(employeeResponse);
        }
        return employeeResponseList;
    }

    @Override
    public EmployeeResponse getEmployee(Long id) {
        EmployeeResponse employeeResponse=new EmployeeResponse();
        Employee employee=employeeRepository.findById(id).get();
        employeeResponse.setAddress_city(employee.getAddress().getCity());
        BeanUtils.copyProperties(employee,employeeResponse);
        return employeeResponse;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }

}
