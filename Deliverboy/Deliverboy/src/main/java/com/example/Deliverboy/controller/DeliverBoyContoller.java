package com.example.Deliverboy.controller;

import com.example.Deliverboy.service.DeliverBoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class DeliverBoyContoller {

    @Autowired
    private DeliverBoyService deliverBoyService;

    @PutMapping(value = "/update")
    public ResponseEntity locationUpate(){
        this.deliverBoyService.liveLocation("Sending the live location");
        return new ResponseEntity<>(Map.of("Message", "Location sent"), HttpStatus.OK);
    }
}
