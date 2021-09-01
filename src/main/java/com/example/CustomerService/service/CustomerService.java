package com.example.CustomerService.service;

import com.example.CustomerService.classes.MyOrders;
import com.example.CustomerService.classes.Product;
import com.example.CustomerService.entity.Customer;
import com.example.CustomerService.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService
{
 @Autowired
    CustomerRepo repo;

 @Autowired
    RestTemplate restTemplate;

 public Customer saveCust(Customer c)
 {
     return repo.save(c);
 }


 public MyOrders getMyOrders(int custId)
 {
     Optional<Customer> cust=repo.findById(custId);
     int pid= cust.get().getPid();
     Product product=restTemplate.getForObject("http://localhost/8051/list"+pid,Product.class);
     MyOrders myOrders=new MyOrders();
     myOrders.setCustomer(cust.get());
     myOrders.setProduct(product);
     return myOrders;
 }
}
