package org.interview.kafein.producer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

	@Autowired
	KafkaTemplate<String, String> kafkaSender;

	public void writeMessage(int id, List<Integer> followerList) {
		StringBuilder builder = new StringBuilder();
		builder.append(id);
		for(Integer i : followerList) {
        	builder.append(";");
        	builder.append(i);
        }
		this.kafkaSender.send("kafein", builder.toString());
	}

}
