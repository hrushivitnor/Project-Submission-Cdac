package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Buyers;
import com.app.pojos.UpdateCropBuyer;


public interface IBuyerService {
	List<Buyers> getAllBuyers();
	Buyers addBuyer(Buyers transientBuyer);
	Optional<Buyers> getBuyerDetailsbyId(int bid);
	Buyers UpdateBuyer(int bid,Buyers detachedPojo);
	String deleteBuyerById(int bid);
	UpdateCropBuyer addCropBuyer(UpdateCropBuyer c);
}
