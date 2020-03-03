package com.felipestella.whorkshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.felipestella.whorkshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}