package com.mapping.Mapping.controller;

import com.mapping.Mapping.common.response.BaseResponse;
import com.mapping.Mapping.common.response.ContentResponse;
import com.mapping.Mapping.request.dto.ItemRequest;
import com.mapping.Mapping.rest.enums.RequestStatus;
import com.mapping.Mapping.service.ItemService;
import com.mapping.Mapping.utils.Constants;
import com.mapping.Mapping.utils.EndpointURI;
import com.mapping.Mapping.utils.ValidationResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private ValidationResponseCode validationResponseCode;
    @PostMapping(value = EndpointURI.ITEM)
    public ResponseEntity<Object> safeItem(@RequestBody ItemRequest itemRequest)
    {
        itemService.createItem(itemRequest);
        return ResponseEntity.ok(new BaseResponse(RequestStatus.SUCCESS.getStatus(),
                validationResponseCode.getCommonSuccessCode(),
                validationResponseCode.getItemSaveSuccessMessage()));
    }
    @PutMapping(value = EndpointURI.ITEM)
    public ResponseEntity<Object> updateItem(@RequestBody ItemRequest itemRequest)
    {
        if(!itemService.existsById(itemRequest.getId()))
        {
            return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                    validationResponseCode.getItemNotExists(),
                    validationResponseCode.getItemNotExistsMessage()));
        }
        itemService.createItem(itemRequest);
        return ResponseEntity.ok(new BaseResponse(RequestStatus.SUCCESS.getStatus(),
                validationResponseCode.getCommonSuccessCode(),
                validationResponseCode.getItemSaveSuccessMessage()));
    }
    @GetMapping(value = EndpointURI.ITEM)
    public ResponseEntity<Object> getALlItem()
    {
        return ResponseEntity.ok(new ContentResponse<>(Constants.ITEMS,itemService.getAllItem(),RequestStatus.SUCCESS.getStatus(),
                validationResponseCode.getCommonSuccessCode(),validationResponseCode.getGetAllItemSuccessMessage()));
    }
    @GetMapping(value = EndpointURI.ITEM_BY_ID)
    public ResponseEntity<Object> getItemById(@PathVariable Long id)
    {
        if(!itemService.existsById(id))
        {
            return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                    validationResponseCode.getItemNotExists(),
                    validationResponseCode.getItemNotExistsMessage()));
        }
        return ResponseEntity.ok(new ContentResponse<>(Constants.ITEM,itemService.getItemById(id),
                RequestStatus.SUCCESS.getStatus(),validationResponseCode.getCommonSuccessCode() ,validationResponseCode.getGetItemSuccessMessage()));
    }
    @DeleteMapping(value = EndpointURI.ITEM_BY_ID)
    public ResponseEntity<Object> deleteItem(@PathVariable Long id)
    {
        if(!itemService.existsById(id))
        {
            return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                    validationResponseCode.getItemNotExists(),
                    validationResponseCode.getItemNotExistsMessage()));
        }
        itemService.deleteItem(id);
        return ResponseEntity.ok(new BaseResponse(RequestStatus.SUCCESS.getStatus(),
                validationResponseCode.getCommonSuccessCode(),validationResponseCode.getDeleteItemSuccessMessage()));
    }
}
