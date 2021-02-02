package com.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Credentials;
import com.app.service.CredentialServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("/credentials")
public class CredentialsController {
 @Autowired
 private CredentialServiceImpl service;
	public CredentialsController() {
		System.out.println("in ctor of "+getClass().getName());
	}
   
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserBuyerDetailsbyId(@PathVariable int id)
	{
		System.out.println("in get buyerbyid "+id);
		try
		{
		Optional<Credentials> b=service.getUserById(id);
		return new ResponseEntity<>(b, HttpStatus.OK);
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	
	//@RequestMapping(value="/registeruser",produces = "application/json",method = RequestMethod.POST)
	@PostMapping("/registeruser")
	public Credentials registerUser(@RequestBody Credentials user) throws Exception
	{
		System.out.println("------------------------------"+user);
		String tempUsername=user.getUserName();
		if(tempUsername!=null && !"".equals(tempUsername))
		{
			Credentials userObj=service.fetchUserByUsername(tempUsername);
			if(userObj!=null)
			{
				throw new Exception("user with  username"+tempUsername+"already exist");
			}
		}
		Credentials userObj=null;
		System.out.println(user);
		userObj=service.saveUserCredentials(user);
		Credentials u= service.fetchUserByUsername(userObj.getUserName());
		System.out.println("+++++++++++++++"+u);
		 return u;
	}
	
	//@PostMapping("/login")
	@RequestMapping(value="/login",method = RequestMethod.POST,produces = "application/json")
	public Credentials loginUser(@RequestParam Credentials user) throws Exception
	{
		System.out.println("in user login....   "+user);
		String tempUserName=user.getUserName();
		String password=user.getPassword();
		Credentials userObj=null;
	  if(tempUserName!=null&&password!=null)
	  {
		  userObj=service.fetchUserByUsernameAndPassword(tempUserName, password);
	  }
	  if(userObj==null)
	  {
		  throw new Exception("Incorrect Credentials Plz reenter Credentials correctly...");
	  }
	  return userObj;
	}
	
	
}
