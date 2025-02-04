package com.kafkaLearning.kafka.producer;

import com.kafkaLearning.kafka.payload.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaJsonProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void publishMessage(Student student) {
        log.info(format(" 📤 Sending message to pratik Topic: %s", student));
        Message<Student> message = MessageBuilder
                .withPayload(student)
                .setHeader(KafkaHeaders.TOPIC,"pratik-topic")
                .build();
        kafkaTemplate.send(message);

    }
}
