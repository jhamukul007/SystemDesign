package com.producer.producer;

import com.producer.constants.ProducerConstants;
import com.producer.enums.TopicDetailsEnum.TopicDetail;

import lombok.Data;

public @Data class KafkaRecordDocument extends IDocument {
	private String key;
	private String value;

	public KafkaRecords getRecords() {
		KafkaRecords records=new KafkaRecords();
		records.setKey(this.getKey());
		records.setValue(this.getValue());
		records.setTopicName(ProducerConstants.getIns().getTopicName());
		return records;
	}
}
