package com.example.CustomerService.classes;

import com.example.CustomerService.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyOrders
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Customer customer;
    private Product product;
}
