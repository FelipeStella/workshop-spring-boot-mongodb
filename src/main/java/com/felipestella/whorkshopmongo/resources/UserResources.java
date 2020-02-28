package com.felipestella.whorkshopmongo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipestella.whorkshopmongo.domain.User;

@RestController
@RequestMapping(value="users")
public class UserResources {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> listUsuario = new ArrayList<>();
		listUsuario.add(new User("1", "Felipe stella", "felipedasilva.stella@gmail.com"));
		listUsuario.add(new User("2", "Thais Duarte", "thais_oliveiraduarte@outlook.com"));
		listUsuario.add(new User("3", "Theo Benjamin", "theobenja@gmail.com"));
		return ResponseEntity.ok().body(listUsuario);		
	}
}
