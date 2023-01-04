package binyam.apachekafka.apachekafkaproject1.kafka;


import binyam.apachekafka.apachekafkaproject1.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger logger= LoggerFactory.getLogger(JsonKafkaConsumer.class);


    @KafkaListener(topics = "${spring.kafka.topic.name.jsonTopic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(User message){
       logger.info(String.format("Message Received-> %s", message));
    }
}
