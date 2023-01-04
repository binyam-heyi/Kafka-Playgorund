package binyam.apachekafka.apachekafkaproject1.controller;

import binyam.apachekafka.apachekafkaproject1.kafka.JsonKafkaProducer;
import binyam.apachekafka.apachekafkaproject1.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }


    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {

        kafkaProducer.publish(user);

        return ResponseEntity.ok("JSON Message Sent to kafka Topic");

    }
}
