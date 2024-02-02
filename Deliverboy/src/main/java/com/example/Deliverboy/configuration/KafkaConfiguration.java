package com.example.Deliverboy.configuration;

import com.example.Deliverboy.constants.KafkaConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfiguration {

    @Bean
    public NewTopic topic(){
        return TopicBuilder
                .name(KafkaConstants.LOCATION_UPDATE)
                .build();
    }
}
