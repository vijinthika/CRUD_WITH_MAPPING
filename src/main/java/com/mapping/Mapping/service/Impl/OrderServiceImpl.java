package com.mapping.Mapping.service.Impl;

import com.mapping.Mapping.entities.Item;
import com.mapping.Mapping.entities.Orders;
import com.mapping.Mapping.repositories.OrderRepository;
import com.mapping.Mapping.request.dto.OrderRequest;
import com.mapping.Mapping.response.dto.OrderResponse;
import com.mapping.Mapping.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void safeOrder(OrderRequest orderRequest) {
        Orders orders=new Orders();
        List<Item> itemList=new ArrayList<>();
        List<Long> item_ids=orderRequest.getItem_id();
       int price=0;
        for (Long item_id:item_ids
             ) {
            Item item=new Item();
            item.setId(item_id);
            itemList.add(item);
            price=price+item.getPrice();
            orders.setTotalPrice(price);
        }
        orders.setItems(itemList);
        BeanUtils.copyProperties(orderRequest,orders);
        orderRepository.save(orders);
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        List<OrderResponse> orderResponseList=new ArrayList<>();
        List<Orders> ordersList=orderRepository.findAll();
        for (Orders order:ordersList
             ) {
            OrderResponse orderResponse=new OrderResponse();
            orderResponse.setItem_List(order.getItems());
            BeanUtils.copyProperties(order,orderResponse);
            orderResponseList.add(orderResponse);
        }
        return orderResponseList;
    }

    @Override
    public boolean existsById(Long id) {
        return orderRepository.existsById(id);
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        OrderResponse orderResponse=new OrderResponse();
        Orders orders=orderRepository.findById(id).get();
        orderResponse.setItem_List(orders.getItems());
        BeanUtils.copyProperties(orders,orderResponse);
        return orderResponse;
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

}
