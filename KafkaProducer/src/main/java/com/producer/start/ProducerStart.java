package com.producer.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producer.producer.KafkaEventProducer;
import com.producer.producer.KafkaRecordDocument;

@RestController("/kafka")
public class ProducerStart {
	
	@Autowired
	private KafkaEventProducer eventProducer;
	
	@RequestMapping(name = "/send/message", consumes = "application/json", produces = "application/json" )
	public ResponseEntity<String> sendMessage(@RequestBody KafkaRecordDocument recordDoc){
		if(recordDoc==null)
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		eventProducer.sendMessageToKafka(recordDoc.getRecords());
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
}
