package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Crop;

public interface ICropAdminService  {
	List<Crop> getAllCrops();
	Crop addCrop(Crop transientCrop);
	Optional<Crop> getCropDetailsbyId(int cropId);
	String deleteCropById(int cropId);
}
