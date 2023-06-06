package com.mapping.Mapping.controller;

import com.mapping.Mapping.common.response.BaseResponse;
import com.mapping.Mapping.common.response.ContentResponse;
import com.mapping.Mapping.request.dto.OrderRequest;
import com.mapping.Mapping.rest.enums.RequestStatus;
import com.mapping.Mapping.service.OrderService;
import com.mapping.Mapping.utils.Constants;
import com.mapping.Mapping.utils.EndpointURI;
import com.mapping.Mapping.utils.ValidationResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ValidationResponseCode validationResponseCode;

    @PostMapping(value = EndpointURI.ORDER)
    public ResponseEntity<Object> safeOrder(@RequestBody OrderRequest orderRequest)
    {
        orderService.safeOrder(orderRequest);
        return ResponseEntity.ok(new BaseResponse(RequestStatus.SUCCESS.getStatus(),
                validationResponseCode.getCommonSuccessCode(),
                validationResponseCode.getOrderSaveSuccessMessage()));
    }
    @GetMapping(value = EndpointURI.ORDER)
    public ResponseEntity<Object> getAllOrders()
    {
        return ResponseEntity.ok(new ContentResponse<>(
                Constants.ORDERS,
                orderService.getAllOrders(),
                RequestStatus.SUCCESS.getStatus(),
                validationResponseCode.getCommonSuccessCode(),
                validationResponseCode.getOrderGetALlSuccessMessage()));
    }
    @GetMapping(value = EndpointURI.ORDER_BY_ID)
    public ResponseEntity<Object> getOrderById(@PathVariable Long id)
    {
        if(!orderService.existsById(id))
        {
            return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                    validationResponseCode.getOrderNotExists() ,
                    validationResponseCode.getOrderNotExistsMessage()));
        }
        return ResponseEntity.ok(new ContentResponse<>(
                Constants.ORDER,
                orderService.getOrderById(id),
                RequestStatus.SUCCESS.getStatus(),
                validationResponseCode.getCommonSuccessCode(),
                validationResponseCode.getOrderGetSuccessMessage()));
    }
    @DeleteMapping(value = EndpointURI.ORDER)
    public ResponseEntity<Object> deleteOrder(@PathVariable Long id)
    {
        if(!orderService.existsById(id))
        {
            return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                    validationResponseCode.getOrderNotExists() ,
                    validationResponseCode.getOrderNotExistsMessage()));
        }
        return ResponseEntity.ok(new BaseResponse(RequestStatus.SUCCESS.getStatus(),
                validationResponseCode.getCommonSuccessCode(),
                validationResponseCode.getOrderDelteSuccessMessage()));
    }


}
