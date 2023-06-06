package com.mapping.Mapping.response.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponse {
    private Long id;
    private String name;
    private Long salary;
    private String address_city;
}
