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

import com.app.pojos.Producers;
import com.app.pojos.UpdateCropBuyer;
import com.app.service.IUpdateCropBuyerService;
@RestController
@RequestMapping("/updatecropbuyer")
public class UpdateCropBuyerController {
	@Autowired
	private IUpdateCropBuyerService service;
	public UpdateCropBuyerController() {
		System.out.println("in ctor of " + getClass().getName());
	}
	@GetMapping
	public ResponseEntity<?> listBuyerCrops() {
		System.out.println("in list UpdateBuyerCrops.... " );
		List<UpdateCropBuyer> BuyerCrops= service.getAllBuyerCrop()	;
		if (BuyerCrops.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// non empty list
		return new ResponseEntity<>(BuyerCrops , HttpStatus.OK);
		}
	
	
	@PostMapping
	//@RequestBody => un marshalling
	public ResponseEntity<?> createNewBuyerCrop(@RequestBody UpdateCropBuyer newBuyerCrop) {
		System.out.println("in create UpdatedBuyerCrop " + newBuyerCrop);
		try {
			UpdateCropBuyer crop = service.addUpdateCropBuyer(newBuyerCrop);
			return new ResponseEntity<>(crop, HttpStatus.CREATED);
		} catch (RuntimeException e) {
			e.printStackTrace();
			// resp pkt : set status code : 500 (server internal error)
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{ubid}")
	public ResponseEntity<?> getBuyerCropDetailsbyId(@PathVariable int ubid)
	{
		System.out.println("in get BuyerCrop by id "+ubid);
		try
		{
		Optional<UpdateCropBuyer> bc=service.getBuyersCropDetailsbyId(ubid);
		return new ResponseEntity<>(bc, HttpStatus.OK);
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{ubid}")
	public ResponseEntity <?>updateBuyerCropDetials(@PathVariable int ubid,@RequestBody UpdateCropBuyer detachedPojo)
	{
		System.out.println("in controller update  BuyerCrop "+ubid+" "+detachedPojo);
		UpdateCropBuyer updateCrop=service.UpdateCropBuyer(ubid, detachedPojo);
		if(updateCrop==null)
		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(updateCrop,HttpStatus.OK);
	}
	
	@DeleteMapping("/{ubid}")
	public String deleteProducer(@PathVariable int ubid)
	{
		System.out.println("in BuyerCrop delete controller"+ubid);
		return service.deleteBuyerCropById(ubid);
	}
	@GetMapping("/{bid}")
	public ResponseEntity<?> getUpdtedCropsByBid(@PathVariable int bid)
	{
		
		System.out.println("in list  update all crop buyers.... "+bid );
	try {
		List <UpdateCropBuyer> u= service.getallUpdatedCropsByBid(bid);
		System.out.println("--------------------------"+u);
		return new ResponseEntity<>(u,HttpStatus.OK);
	}
	catch(RuntimeException e)
	{
		return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}
}