package com.felipestella.whorkshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipestella.whorkshopmongo.domain.Post;
import com.felipestella.whorkshopmongo.services.PostService;

@RestController
@RequestMapping(value="posts")
public class PostResources {
	
	@Autowired
	private PostService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findPostsById(@PathVariable String id){
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
	}

}
