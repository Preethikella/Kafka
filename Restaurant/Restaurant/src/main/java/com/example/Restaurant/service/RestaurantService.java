package com.example.Restaurant.service;

import com.example.Restaurant.constants.KafkaConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public boolean notificationUpdate(String notification){
        kafkaTemplate.send(KafkaConstants.NOTIFICATION_UPDATE, notification);
        return true;
    }
}
