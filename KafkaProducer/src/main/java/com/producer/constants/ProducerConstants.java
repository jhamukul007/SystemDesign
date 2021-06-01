package com.producer.constants;

import com.producer.enums.TopicDetailsEnum.TopicDetail;

public class ProducerConstants {
	
	private static class ProducerConstantsHelper{
		private static final ProducerConstants INS=new ProducerConstants();
	}
	
	public static ProducerConstants getIns() {
		return ProducerConstantsHelper.INS;
	}
	
	public String getTopicName() {
		return TopicDetail.DATA_TRANSFER_V1.getTopicName();
	}
}
