package com.example.Customer.service;

import com.example.Customer.constants.KafkaConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "location-update", groupId = "live-location")
    public void receivedNotification(String location){
       log.info(location);
    }

    public boolean customerUpdate(String update){
        this.kafkaTemplate.send(KafkaConstants.CUSTOMER_TOPIC, update);
        return true;
    }
}
