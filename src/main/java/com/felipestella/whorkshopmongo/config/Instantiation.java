package com.felipestella.whorkshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.felipestella.whorkshopmongo.domain.Post;
import com.felipestella.whorkshopmongo.domain.User;
import com.felipestella.whorkshopmongo.dto.AuthorDto;
import com.felipestella.whorkshopmongo.repository.PostRepository;
import com.felipestella.whorkshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository repositUser;
	
	@Autowired
	private PostRepository repositPost;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		
		repositUser.deleteAll();
		repositPost.deleteAll();
		
		User felipe = new User(null, "Felipe da Silva Stella", "felipedasilva.stella@gmail.com");
		User thais = new User(null, "Thais Duarte Oliveira", "thais_lipe123@hotmail.com");
		User theo = new User(null, "Theo Benjamim Oliveira Stella", "theobenjamin@outlook.com");
		
		repositUser.saveAll(Arrays.asList(felipe, thais, theo));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDto(felipe));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDto(felipe));

		repositPost.saveAll(Arrays.asList(post1, post2));
	}

}
