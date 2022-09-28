package com.SBkafkareal.wikimedia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.SBkafkareal.wikimedia.entity.WikimediaData;
import com.SBkafkareal.wikimedia.repository.WikimediaDataRepository;

@Service
public class KafkaDatabaseConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
	
	private WikimediaDataRepository dataRepository;
	
	public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository) {
		super();
		this.dataRepository = dataRepository;
	}



	@KafkaListener(topics="wikimedia_recentchange",groupId = "myGroup")
	public void consume(String eventMessage)
	{
		LOGGER.info(String.format("event message received -> %s", eventMessage));
		
		WikimediaData wikimediaData=new WikimediaData();
		
		wikimediaData.setWikiEventData(eventMessage);
		
		dataRepository.save(wikimediaData);
		
	}
}
