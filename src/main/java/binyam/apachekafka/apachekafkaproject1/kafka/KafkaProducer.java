package binyam.apachekafka.apachekafkaproject1.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final Logger logger= LoggerFactory.getLogger(KafkaProducer.class);

    @Value("${spring.kafka.topic.name.firstTopic}")
    private String firstTopic;


    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(String message){
        logger.info(String.format("Message Sent %s", message));
        kafkaTemplate.send(firstTopic, message);
    }
}
