package com.felipestella.whorkshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipestella.whorkshopmongo.domain.Post;
import com.felipestella.whorkshopmongo.repository.PostRepository;
import com.felipestella.whorkshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository reposit;
	
	public Post findById(String id) {
		Optional<Post> post = reposit.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Comando não encontrado"));
		
	}
	
	public List<Post> findByTitle(String text){
		return reposit.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date initialDate, Date finalDate){
		finalDate = new Date(finalDate.getTime() + 24 * 60 * 60 *1000);
		return reposit.fullSearch(text, initialDate, finalDate);
	}
	
}
