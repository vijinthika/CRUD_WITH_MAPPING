package com.mapping.Mapping.response.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponse {
    private Long id;
    private String name;
    private Long addressId;
    private String addressCity;

}
