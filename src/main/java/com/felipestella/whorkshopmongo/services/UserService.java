package com.felipestella.whorkshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipestella.whorkshopmongo.domain.User;
import com.felipestella.whorkshopmongo.repository.UserRepository;
import com.felipestella.whorkshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repositorio;
	
	public List<User> findAll(){
		return repositorio.findAll();
	}
	
	public User findById(String id) {
		Optional<User> usuario = repositorio.findById(id);
		return usuario.orElseThrow(() -> new ObjectNotFoundException("Comando não encontrado"));
		
	}
}
