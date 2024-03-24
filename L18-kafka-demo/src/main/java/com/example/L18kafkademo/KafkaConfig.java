package com.example.L18kafkademo;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class KafkaConfig {


    @Value("${kafka.bootstrapAddress}")
    private String bootstrapServers;

    @Bean
    public ProducerFactory getObjectProducerFactory(){
        Map<String,Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        //configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,  JsonSerializer.class);

        return new DefaultKafkaProducerFactory(configs);
    }

    @Bean
    public KafkaTemplate<String,Object> getKafkaTemplateForObjects(){
        return new KafkaTemplate<>(getObjectProducerFactory());
    }

    @Bean
    public ProducerFactory getStringProducerFactory(){
        Map<String,Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory(configs);
    }

    @Bean
    public KafkaTemplate<String,String> getKafkaTemplate(){
        return new KafkaTemplate<>(getStringProducerFactory());
    }


    @Bean
    public JavaMailSender javaMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setUsername("jbdl.ewallet@gmail.com");
        //javaMailSender.setPassword("fiujsxiibtzjkpvq");
//        javaMailSender.setPassword("zopoiuvqpotrrdad");
        javaMailSender.setPassword("rhbdqiljjigsqddg");
        javaMailSender.setPort(587);
        Properties properties = javaMailSender.getJavaMailProperties();
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.debug", true); // For debugging purpose
        return javaMailSender;
    }
}
