package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Credentials;

public interface ICredentialsDao extends JpaRepository<Credentials, Integer>{
	
	public Credentials findByUserName(String username);

	public Credentials findByUserNameAndPassword(String username,String pass);
}
