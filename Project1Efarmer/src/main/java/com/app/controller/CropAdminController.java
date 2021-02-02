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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Crop;
import com.app.service.ICropAdminService;

@RestController
@RequestMapping("/crop")
public class CropAdminController {
	@Autowired
	private ICropAdminService service;
	public CropAdminController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	
	@GetMapping
	public ResponseEntity<?> listCrops() {
		System.out.println("in list crops.... " );
		List<Crop> crops= service.getAllCrops();	
		if (crops.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// non empty list
		return new ResponseEntity<>(crops, HttpStatus.OK);
		}

	
	@PostMapping
	//@RequestBody => un marshalling
	public ResponseEntity<?> createNewCrop(@RequestBody Crop newCrop) {
		System.out.println("in create crop " + newCrop);
		try {
			Crop crop = service.addCrop(newCrop);
			return new ResponseEntity<>(crop, HttpStatus.CREATED);
		} catch (RuntimeException e) {
			e.printStackTrace();
			// resp pkt : set status code : 500 (server internal error)
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{cropId}")
	public ResponseEntity<?> getCropDetailsbyId(@PathVariable int cropId)
	{
		System.out.println("in get crop by id "+cropId);
		try
		{
		Optional<Crop> c=service.getCropDetailsbyId(cropId);
		return new ResponseEntity<>(c, HttpStatus.OK);
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{cropId}")
	public String deleteCropById(@PathVariable int cropId)
	{
		System.out.println("in crop delete controller"+cropId);
		return service.deleteCropById(cropId);
	}
}
