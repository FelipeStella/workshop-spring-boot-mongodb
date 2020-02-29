package com.felipestella.whorkshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipestella.whorkshopmongo.domain.User;
import com.felipestella.whorkshopmongo.dto.UserDto;
import com.felipestella.whorkshopmongo.services.UserService;

@RestController
@RequestMapping(value="users")
public class UserResources {
	
	@Autowired
	private UserService servico;
	
	@GetMapping
	public ResponseEntity<List<UserDto>> findAll(){
		List<User> listUsuario = servico.findAll();
		List<UserDto> listUsuarioDto = listUsuario.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listUsuarioDto);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDto> findById(@PathVariable String id){
		User usuario = servico.findById(id);
		return ResponseEntity.ok().body(new UserDto(usuario));
	}
}
