package com.youtube.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.youtube.model.Video;

public interface VideoRepository extends MongoRepository<Video, String>{

}
