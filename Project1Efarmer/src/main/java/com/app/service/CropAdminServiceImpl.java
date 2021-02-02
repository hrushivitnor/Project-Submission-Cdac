package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICropAdminDao;
import com.app.pojos.Crop;
@Service
@Transactional
public class CropAdminServiceImpl implements ICropAdminService {
	@Autowired
	private ICropAdminDao dao;
	public CropAdminServiceImpl() {
		System.out.println("in ctor of " + getClass().getName());
	}

	@Override
	public List<Crop> getAllCrops() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Crop addCrop(Crop transientCrop) {
		// TODO Auto-generated method stub
		return dao.save(transientCrop);
	}

	@Override
	public Optional<Crop> getCropDetailsbyId(int cropId) {
		// TODO Auto-generated method stub
		return dao.findById(cropId);
	}

	@Override
	public String deleteCropById(int cropId) {
		// TODO Auto-generated method stub
		dao.deleteById(cropId);
		return "Producer  with id"+cropId+" is deleted";
	}

}
