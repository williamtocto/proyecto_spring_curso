package com.example.springproyect.app.service;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springproyect.app.entity.User;
import com.example.springproyect.app.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserRepository userR;

	@Override
	@Transactional(readOnly=true)
	public Iterable<User> findAll() {
		return userR.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<User> findAll(Pageable pageable) {
		return (Page<User>) userR.findAll((Sort) pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<User> findById(Long id) {
		return userR.findById(id);
	}

	@Override
	@Transactional
	public User save(User user) {
		return userR.save(user);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		userR.deleteById(id);
	}
	
}
