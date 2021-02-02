package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.UpdateCropBuyer;

public interface IUpdateCropBuyerService {
	List<UpdateCropBuyer> getAllBuyerCrop();
	UpdateCropBuyer addUpdateCropBuyer(UpdateCropBuyer transientUpdaeCropBuyer);
	Optional<UpdateCropBuyer> getBuyersCropDetailsbyId(int ubid);
	UpdateCropBuyer UpdateCropBuyer(int ubid,UpdateCropBuyer detachedPojo);
	String deleteBuyerCropById(int ubid);
	UpdateCropBuyer addNewUpdatedBuyerCrop(UpdateCropBuyer c);
	 List<UpdateCropBuyer>getallUpdatedCropsByBid(int bid);
}
