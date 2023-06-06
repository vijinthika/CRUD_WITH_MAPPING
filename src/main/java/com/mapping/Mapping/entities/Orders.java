package com.mapping.Mapping.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int totalPrice;
    @ManyToMany
    @JoinColumn(name = "item_id",nullable = false)
    private List<Item> items;



}
