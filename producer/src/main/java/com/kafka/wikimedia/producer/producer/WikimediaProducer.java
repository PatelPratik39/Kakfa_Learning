package com.kafka.wikimedia.producer.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class WikimediaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void publishMessage(String message){
//        log.info(format(" 📤 Sending message to pratik Topic: %s  📤 ", message));
        kafkaTemplate.send("wikimedia-stream", message);
    }
}
