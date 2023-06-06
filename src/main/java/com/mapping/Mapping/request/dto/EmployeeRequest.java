package com.mapping.Mapping.request.dto;

import com.mapping.Mapping.entities.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {
    private Long id;
    private String name;
    private Long salary;
    private Long addressId;
}
