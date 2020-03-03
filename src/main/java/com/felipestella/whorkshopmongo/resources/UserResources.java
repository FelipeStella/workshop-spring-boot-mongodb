package com.felipestella.whorkshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.felipestella.whorkshopmongo.domain.Post;
import com.felipestella.whorkshopmongo.domain.User;
import com.felipestella.whorkshopmongo.dto.UserDto;
import com.felipestella.whorkshopmongo.services.UserService;

@RestController
@RequestMapping(value="users")
public class UserResources {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDto>> findAll(){
		List<User> listUser = service.findAll();
		List<UserDto> listUserDto = listUser.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listUserDto);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDto> findById(@PathVariable String id){
		User user = service.findById(id);
		return ResponseEntity.ok().body(new UserDto(user));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDto objDto){
		User newUser = service.fromDto(objDto);
		newUser = service.insert(newUser);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserDto> update(@RequestBody UserDto objDto, @PathVariable String id){
		User updateDataUser = service.fromDto(objDto);
		updateDataUser = service.update(id, updateDataUser);
		return ResponseEntity.ok().body(new UserDto(updateDataUser));
	}
	
	@GetMapping(value = "/{id}/posts")
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
		User user = service.findById(id);
		return ResponseEntity.ok().body(user.getListPost());
	}
	
}
