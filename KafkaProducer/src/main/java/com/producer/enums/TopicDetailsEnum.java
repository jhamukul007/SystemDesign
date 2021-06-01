package com.producer.enums;

public class TopicDetailsEnum {
	public enum TopicDetail{
		DATA_TRANSFER_V1{

			@Override
			public String getTopicName() {
				// TODO Auto-generated method stub
				return "data_v1";
			}
		};
		abstract public String getTopicName();
	}

}
