package com.javatechie.jooq.controller;

import com.javatechie.jooq.model.tables.pojos.Customer;
import com.javatechie.jooq.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public String addCustomer(@RequestBody Customer customer) {
        customerService.insertCustomer(customer);
        return "customer added";
    }


    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        List<Customer> c = customerService.getCustomers();
        return c;

    }

}
