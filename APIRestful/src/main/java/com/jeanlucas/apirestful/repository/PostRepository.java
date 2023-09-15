package com.jeanlucas.apirestful.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jeanlucas.apirestful.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}

