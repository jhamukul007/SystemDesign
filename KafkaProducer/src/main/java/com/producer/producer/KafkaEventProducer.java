package com.producer.producer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.stereotype.Component;

@Component
public class KafkaEventProducer {
	
	public void sendMessageToKafka(KafkaRecords records) {
		if(records==null)
			return;
		Properties properties=getProducerProperties();
		Producer<String, String> producer= new KafkaProducer<String, String>(properties);
		ProducerRecord<String, String> record=new ProducerRecord<String, String>(records.getTopicName(), records.getKey(), records.getValue());
		producer.send(record, new Callback() {
			
			@Override
			public void onCompletion(RecordMetadata metadata, Exception exception) {
				if(exception!=null) {
					System.out.println("Getting error while pushing data to kafka broker "+ exception);
				}
				else
					System.out.println("Time Stemp "+metadata.hasTimestamp()+ "  Partition "+metadata.partition()
					+"   Offset "+metadata.offset());
				
			}
		});
	}
	private Properties getProducerProperties() {
		Properties property=new Properties();
		property.put("bootstrap.server", "localhost:9200, localhost:9300");
		property.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		property.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		property.put("retries", 4);
		property.put("retry.backoff.ms", 150);
		property.put("acks", -1);
		property.put("buffer.memory", 12252210);
		property.put("max.block.ms", 6000);
		property.put("max.in.flight.requests.per.connection", 1);
		return property;
	}
	private Map<Object,Object> getProducerConfigMap(){
		Map<Object,Object> config=new HashMap<>();
		config.put("bootstrap.server", "localhost:9200, localhost:9300");
		config.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		config.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		return config;
	}
}
