package com.mapping.Mapping.request.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequest {
    private Long id;
    private String name;
    private Long address_Id;
}
