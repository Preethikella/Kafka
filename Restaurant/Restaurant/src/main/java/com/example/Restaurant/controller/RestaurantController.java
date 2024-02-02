package com.example.Restaurant.controller;

import com.example.Restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/notification")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PutMapping(value = "/update")
    public ResponseEntity notificationUpdate(){
        this.restaurantService.notificationUpdate("Order has been placed");
        return new ResponseEntity<>(Map.of("Message", "Order Placed"), HttpStatus.OK);
    }
}
