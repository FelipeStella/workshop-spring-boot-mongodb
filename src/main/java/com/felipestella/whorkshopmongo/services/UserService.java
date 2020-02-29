package com.felipestella.whorkshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipestella.whorkshopmongo.domain.User;
import com.felipestella.whorkshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repositorio;
	
	public List<User> findAll(){
		return repositorio.findAll();
	}
}
