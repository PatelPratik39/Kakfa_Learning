package com.kafkaLearning.kafka.consumer;

import com.kafkaLearning.kafka.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
public class KafkaConsumer {

//    @KafkaListener(topics = "pratik-topic", groupId = "myGroup")
    public void consumeMessage(String message) {
        log.info(format(" 📩 Consumed messages from pratik-topic : : %s", message));
    }

    @KafkaListener(topics = "pratik-topic", groupId = "myGroup")
    public void consumeJsonMessage(Student student) {
        log.info(format(" 📩 Consumed messages from pratik-topic : : %s 📩", student.toString()));
    }
}
