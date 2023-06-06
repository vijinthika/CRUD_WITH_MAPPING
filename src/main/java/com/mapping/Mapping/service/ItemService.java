package com.mapping.Mapping.service;

import com.mapping.Mapping.request.dto.EmployeeRequest;
import com.mapping.Mapping.request.dto.ItemRequest;
import com.mapping.Mapping.response.dto.EmployeeResponse;
import com.mapping.Mapping.response.dto.ItemResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ItemService {
    public void createItem(ItemRequest itemRequest);

    public List<ItemResponse> getAllItem();

    public ItemResponse getItemById(Long id);


    public boolean existsById(Long id);

    public void deleteItem(Long id);


}
