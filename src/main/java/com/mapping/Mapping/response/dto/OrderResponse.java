package com.mapping.Mapping.response.dto;

import com.mapping.Mapping.entities.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderResponse {
    private Long id;
    private int totalPrice;
    private List<Item> item_List;
}
