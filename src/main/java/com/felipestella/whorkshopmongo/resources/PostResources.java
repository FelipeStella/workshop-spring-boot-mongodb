package com.felipestella.whorkshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.felipestella.whorkshopmongo.domain.Post;
import com.felipestella.whorkshopmongo.resources.util.URL;
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
	
	@GetMapping(value="/titlesearch")
	public ResponseEntity<List<Post>> findPostsByTitle(@RequestParam(value="txt", defaultValue = "") String text){
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/fullsearch")
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value="txt", defaultValue = "") String text,
			@RequestParam(value="initialDate", defaultValue = "") String initialDate,
			@RequestParam(value="finalDate", defaultValue = "") String finalDate
			){
		text = URL.decodeParam(text);
		Date minDate = URL.convertDate(initialDate, new Date(0L));
		Date maxDate = URL.convertDate(finalDate, new Date());
		List<Post> list = service.fullSearch(text, minDate, maxDate);
		return ResponseEntity.ok().body(list);
	}

}
