package com.kafkaLearning.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic createTopic() {
        return TopicBuilder
                .name("pratik-topic")  // ✅ Topic Name
                .partitions(3)         // ✅ Number of Partitions
                .replicas(1)           // ✅ Replication Factor
                .build();
    }
}
