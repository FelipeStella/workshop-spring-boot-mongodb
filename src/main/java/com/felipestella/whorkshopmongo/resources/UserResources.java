package com.felipestella.whorkshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipestella.whorkshopmongo.domain.User;
import com.felipestella.whorkshopmongo.services.UserService;

@RestController
@RequestMapping(value="users")
public class UserResources {
	
	@Autowired
	private UserService servico;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> listUsuario = servico.findAll();
		return ResponseEntity.ok().body(listUsuario);		
	}
}
