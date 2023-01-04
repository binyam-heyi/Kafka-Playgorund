package binyam.apachekafka.apachekafkaproject1.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {



    private static final Logger logger= LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name.firstTopic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message){
       logger.info(String.format("Message Received %s", message));
    }
}
