package binyam.apachekafka.apachekafkaproject1.kafka;

import binyam.apachekafka.apachekafkaproject1.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    private static  final Logger logger= LoggerFactory.getLogger(JsonKafkaProducer.class);


    @Value("${spring.kafka.topic.name.jsonTopic}")
    private String secondTopic;

    private KafkaTemplate<String, User> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(User user){
        Message<User> message = MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC, secondTopic).build();
        logger.info(String.format("Message sent ->%s", user));
        kafkaTemplate.send(message);
    }
}
