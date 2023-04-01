package com.mycompany.app;

import org.apache.kafka.clients.producer.KafkaProducer;

/**
 * Hello world!
 *
 */

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
public class App 
{
    private static final Logger log = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {

        String bootstrapServers = "localhost:9092";
        System.out.println("hello world");
        

        // create Producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        System.out.println("connected?");
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>("quickstart", "Hello world");

        producer.send(producerRecord);
        producer.flush();
        producer.close();
        
    }
}
