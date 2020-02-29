package com.felipestella.whorkshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.felipestella.whorkshopmongo.domain.User;
import com.felipestella.whorkshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository repositorioDoUsuario;

	@Override
	public void run(String... args) throws Exception {
		
		repositorioDoUsuario.deleteAll();
		
		User felipe = new User(null, "Felipe da Silva Stella", "felipedasilva.stella@gmail.com");
		User thais = new User(null, "Thais Duarte Oliveira", "thais_lipe123@hotmail.com");
		User theo = new User(null, "Theo Benjamim Oliveira Stella", "theobenjamin@outlook.com");

		repositorioDoUsuario.saveAll(Arrays.asList(felipe, thais, theo));
	}

}
