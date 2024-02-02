package com.example.Customer.controller;

import com.example.Customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PutMapping(value = "/update")
    public ResponseEntity customerUpdate(){
        this.customerService.customerUpdate("Received the food");
        return new ResponseEntity<>(Map.of("Message", "Food recevived"), HttpStatus.OK);
    }
}
