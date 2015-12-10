package com.bus365.kafka;

public class KafkaConsumerDemo {
	public static void main(String[] args) {
		 Consumer consumerThread1 = new Consumer("Consumer1","delete457");

		 consumerThread1.start();
	}
}
