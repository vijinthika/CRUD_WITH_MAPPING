package com.mapping.Mapping.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long salary;
    @OneToOne
    @JoinColumn(name = "address_id",nullable = false)
    private Address address;

}
