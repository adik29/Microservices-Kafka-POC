package com.SBkafkareal.wikimedia;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@Service
public class WikimediaChnageProducer {

	private static final Logger LOGGER=LoggerFactory.getLogger(WikimediaChnageProducer.class);
	
	private KafkaTemplate<String, String> kafkaTemplate;

	public WikimediaChnageProducer(KafkaTemplate<String, String> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage() {
		String topic="wikimedia_recentchange";
		
		//to read realtime stream data from wikimedia we use event source
		
		EventHandler eventHandler=new WikimediaChangeHandler(kafkaTemplate, topic);
		
		String url="https://stream.wikimedia.org/v2/stream/recentchange";
		
		EventSource.Builder builder=new EventSource.Builder(eventHandler, URI.create(url));
		
		EventSource eventSource=builder.build();
		
		eventSource.start();
		
		try {
			TimeUnit.MINUTES.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
     
}
