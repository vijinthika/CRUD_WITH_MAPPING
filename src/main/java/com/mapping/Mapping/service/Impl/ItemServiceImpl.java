package com.mapping.Mapping.service.Impl;

import com.mapping.Mapping.entities.Item;
import com.mapping.Mapping.repositories.ItemRepository;
import com.mapping.Mapping.request.dto.ItemRequest;
import com.mapping.Mapping.response.dto.ItemResponse;
import com.mapping.Mapping.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Override
    public void createItem(ItemRequest itemRequest) {
        Item item=new Item();
        BeanUtils.copyProperties(itemRequest,item);
        itemRepository.save(item);
    }

    @Override
    public List<ItemResponse> getAllItem() {
        List<ItemResponse> itemResponseList=new ArrayList<>();
        List<Item> itemList=itemRepository.findAll();
        for (Item item:itemList
             ) {
            ItemResponse itemResponse=new ItemResponse();
            BeanUtils.copyProperties(item,itemResponse);
            itemResponseList.add(itemResponse);

        }
        return itemResponseList;
    }

    @Override
    public ItemResponse getItemById(Long id) {
        Item item=itemRepository.findById(id).get();
        ItemResponse itemResponse=new ItemResponse();
        BeanUtils.copyProperties(item,itemResponse);
        return itemResponse;
    }

    @Override
    public boolean existsById(Long id) {
        return itemRepository.existsById(id);
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
