package com.producer.producer;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KafkaRecords {
	private String key;
	private String value;
	private String topicName;
}
