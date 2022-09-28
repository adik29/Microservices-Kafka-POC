package com.SBkafkareal.wikimedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SBkafkareal.wikimedia.entity.WikimediaData;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long>{

}
