package com.example.CustomerService.controller;

import com.example.CustomerService.classes.MyOrders;
import com.example.CustomerService.entity.Customer;
import com.example.CustomerService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/save")
    public Customer saveCustomer(@RequestBody Customer customer)
    {
        return customerService.saveCust(customer);
    }

   @GetMapping("/myorders/{cid}")
    public MyOrders myProductOrders(@PathVariable("cid") int custId)
    {
        return customerService.getMyOrders(custId);
    }
}
