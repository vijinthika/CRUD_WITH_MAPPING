package com.mapping.Mapping.request.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {
    private Long id;
    private List<Long> item_id;
}
