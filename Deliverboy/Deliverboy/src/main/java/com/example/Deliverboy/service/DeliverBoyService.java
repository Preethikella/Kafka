package com.example.Deliverboy.service;

import com.example.Deliverboy.constants.KafkaConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DeliverBoyService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "notification-update", groupId = "notification-send")
    public void receiveNotification(String notification){
    log.info(notification);
    }

    public boolean liveLocation(String location){
      this.kafkaTemplate.send(KafkaConstants.LOCATION_UPDATE, location);
      return true;
    }

    @KafkaListener(topics = "customer-topic", groupId = "customer-respone")
    public void customerresponse(String update){
        log.info(update);
    }
}
