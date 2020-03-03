package com.felipestella.whorkshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipestella.whorkshopmongo.domain.User;
import com.felipestella.whorkshopmongo.dto.UserDto;
import com.felipestella.whorkshopmongo.repository.UserRepository;
import com.felipestella.whorkshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository reposit;
	
	public List<User> findAll(){
		return reposit.findAll();
	}
	
	public User findById(String id) {
		Optional<User> usuario = reposit.findById(id);
		return usuario.orElseThrow(() -> new ObjectNotFoundException("Comando não encontrado"));
		
	}
	
	public User insert(User obj) {
		return reposit.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		reposit.deleteById(id);		
	}
	
	public User update(String id, User newUser) {
		User oldUser = findById(id);
		oldUser = updateData(oldUser, newUser);
		return reposit.save(oldUser);
	}
	
	public User updateData(User oldUser, User newUser) {
		oldUser.setName(newUser.getName());
		oldUser.setEmail(newUser.getEmail());
		return oldUser;
	}
	
	public User fromDto(UserDto objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	
	
}
