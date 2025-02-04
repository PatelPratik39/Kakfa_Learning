package com.kafkaLearning.kafka.controller;

import com.kafkaLearning.kafka.payload.Student;
import com.kafkaLearning.kafka.producer.KafkaJsonProducer;
import com.kafkaLearning.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class MessageController {

    public final KafkaProducer kafkaProducer;
    public final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message){
        kafkaProducer.publishMessage(message);
        return ResponseEntity.ok("Message queued successfully!!✅");
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Student student){
        kafkaJsonProducer.publishMessage(student);
        return ResponseEntity.ok("Message queued successfully as JSON format!!✅");
    }
}
