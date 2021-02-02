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

import com.app.pojos.Buyers;
import com.app.pojos.Producers;
import com.app.service.IBuyerService;
import com.app.service.IProducerService;
@RestController
@RequestMapping("/producers")
public class ProducerController {
	@Autowired
	private IProducerService service;
	public ProducerController() {
		
				System.out.println("in ctor of " + getClass().getName());
			}
			// req handling method to display all products
				@GetMapping
				public ResponseEntity<?> listProducers() {
					System.out.println("in list Producers.... " );
					List<Producers> producers= service.getAllProducers();	
					if (producers.isEmpty())
						return new ResponseEntity<>(HttpStatus.NO_CONTENT);
					// non empty list
					return new ResponseEntity<>(producers, HttpStatus.OK);
					}

				
				@PostMapping
				//@RequestBody => un marshalling
				public ResponseEntity<?> createNewProducer(@RequestBody Producers newProducer) {
					System.out.println("in create Producer " + newProducer);
					try {
						Producers producer = service.addProducer(newProducer);
						return new ResponseEntity<>(producer, HttpStatus.CREATED);
					} catch (RuntimeException e) {
						e.printStackTrace();
						// resp pkt : set status code : 500 (server internal error)
						return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
					}
				}
				
				@GetMapping("/{pid}")
				public ResponseEntity<?> getProducerDetailsbyId(@PathVariable int pid)
				{
					System.out.println("in get producerbyid "+pid);
					try
					{
					Optional<Producers> p=service.getProducerDetailsbyId(pid);
					return new ResponseEntity<>(p, HttpStatus.OK);
					}
					catch(RuntimeException e)
					{
						e.printStackTrace();
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
					}
				}

				@PutMapping("/{pid}")
				public ResponseEntity <?>updateProducerDetials(@PathVariable int pid,@RequestBody Producers detachedPojo)
				{
					System.out.println("in controller update  producer"+pid+" "+detachedPojo);
					Producers updateProducer=service.UpdateProducer(pid, detachedPojo);
					if(updateProducer==null)
					
						return new ResponseEntity<>(HttpStatus.NOT_FOUND);
					return new ResponseEntity<>(updateProducer,HttpStatus.OK);
				}
				
				
				@DeleteMapping("/{pid}")
				public String deleteProducer(@PathVariable int pid)
				{
					System.out.println("in producer delete controller"+pid);
					return service.deleteProducerById(pid);
				}
				
				
					
				
		}

	


