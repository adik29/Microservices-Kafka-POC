package com.SBkafkareal.wikimedia.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="wikimedia_recentChange")
public class WikimediaData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String wikiEventData;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWikiEventData() {
		return wikiEventData;
	}

	public void setWikiEventData(String wikiEventData) {
		this.wikiEventData = wikiEventData;
	}
	
	
}
