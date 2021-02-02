package com.app.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICredentialsDao;
import com.app.pojos.Credentials;

@Service
public class CredentialServiceImpl implements ICredentialsService {
@Autowired
private ICredentialsDao dao;
	public CredentialServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Credentials saveUserCredentials(Credentials user) {
	return	dao.save(user);
		
	}
  

	@Override
	public Credentials fetchUserByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findByUserName(username);
	}
	
	@Override
	public Credentials fetchUserByUsernameAndPassword(String username,String pass) {
		// TODO Auto-generated method stub
		return dao.findByUserNameAndPassword(username,pass);
	}

	@Override
	public Optional<Credentials> getUserById(int id) {
		
		return dao.findById(id);
	}
	
}