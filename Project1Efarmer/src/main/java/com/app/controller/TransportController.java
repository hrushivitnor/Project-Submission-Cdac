package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Transport;
import com.app.service.ITransportService;

@RestController
@RequestMapping("/transport")
public class TransportController {
	@Autowired
	private ITransportService service;
	public TransportController() {
			System.out.println("in ctor of " + getClass().getName());

	}

	@GetMapping
	public ResponseEntity<?> listTransports() {
		System.out.println("in list Transport controller.... " );
		List<Transport> transport= service.getAllTransportCompanies();	
		if (transport.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// non empty list
		return new ResponseEntity<>(transport, HttpStatus.OK);
		}

	
	
	@PostMapping
	//@RequestBody => un marshalling
	public ResponseEntity<?> createNewTransport(@RequestBody Transport newTransport) {
		System.out.println("in create transport controller " + newTransport);
		try {
			Transport transport = service.addTransport(newTransport);
			return new ResponseEntity<>(transport, HttpStatus.CREATED);
		} catch (RuntimeException e) {
			e.printStackTrace();
			// resp pkt : set status code : 500 (server internal error)
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{tcid}")
	public ResponseEntity<?> getTransportDetailsbyId(@PathVariable int tcid)
	{
		System.out.println("in get Transport by id controller "+tcid);
		try
		{
		Optional<Transport> t=service.getTransportDetailsbyId(tcid);
		return new ResponseEntity<>(t, HttpStatus.OK);
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{tcid}")
	public ResponseEntity <?>updateTransportDetials(@PathVariable int tcid,@RequestBody Transport detachedPojo)
	{
		System.out.println("in controller update transport"+tcid+" "+detachedPojo);
		Transport updateTransport=service.UpdateTransport(tcid, detachedPojo);
		if(updateTransport==null)
		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(updateTransport,HttpStatus.OK);
	}
	
	@DeleteMapping("/{tcid}")
	public String deleteTransport(@PathVariable int tcid)
	{
		System.out.println("in delete Transport controller"+tcid);
		return service.deleteTransportById(tcid);
	}
	
	
}
