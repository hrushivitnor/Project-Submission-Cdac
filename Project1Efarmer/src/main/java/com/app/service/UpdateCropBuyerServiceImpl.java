package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.IBuyerDao;
import com.app.dao.IUpdateCrop;
import com.app.dao.IUpdateCropBuyerDao;
import com.app.pojos.Buyers;
import com.app.pojos.UpdateCropBuyer;
@Service
@Transactional
public class UpdateCropBuyerServiceImpl implements IUpdateCropBuyerService {
	@Autowired
	private IUpdateCropBuyerDao dao;
	@Autowired
	private IBuyerDao dao1;
	@Autowired
	private IUpdateCrop dao2;
	public UpdateCropBuyerServiceImpl() {
		System.out.println("in ctor of " + getClass().getName());
	}

	@Override
	public List<UpdateCropBuyer> getAllBuyerCrop() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public UpdateCropBuyer addUpdateCropBuyer(UpdateCropBuyer transientUpdaeCropBuyer) {
		// TODO Auto-generated method stub
		return dao.save(transientUpdaeCropBuyer);
	}

	@Override
	public Optional<UpdateCropBuyer> getBuyersCropDetailsbyId(int ubid) {
		// TODO Auto-generated method stub
		return dao.findById(ubid);
	}

	@Override
	public UpdateCropBuyer UpdateCropBuyer(int ubid, UpdateCropBuyer detachedPojo) {

		Optional<UpdateCropBuyer> existingCrop=dao.findById(ubid);
		if(existingCrop.isPresent())
		{
			UpdateCropBuyer uc=existingCrop.get();
			uc.setCropPrice(detachedPojo.getCropPrice());
			uc.setDate(detachedPojo.getDate());
			
		return uc;
		}
		return null;
	
	}

	@Override
	public String deleteBuyerCropById(int ubid) {
		dao.deleteById(ubid);
		return "Crop  with id "+ubid+" is deleted";
	}
	
	
	
	@Override
	public UpdateCropBuyer addNewUpdatedBuyerCrop(UpdateCropBuyer c) {
	   Optional<Buyers> f = dao1.findById(c.getSelectedBuyer().getBid());
	     Buyers buyer = f.orElseThrow(()->new ResourceNotFoundException("Buyer Not Found : Invalid Buyer Id"));
         c.setSelectedBuyer(buyer);
		return dao.save(c);

		/*@Override
		public Course launchNewCourse(Course c) {
		   Optional<Faculty> f = facultyRepo.findById(c.getCourseFaculty().getId());
		     Faculty faculty = f.orElseThrow(()->new ResourceNotFoundException("Faculty Not Found : Invalid Faculty Id"));
	         c.setCourseFaculty(faculty);
			return courseRepo.save(c);*/
		
		
	}

	@Override
	public List<UpdateCropBuyer> getallUpdatedCropsByBid(int ubid) {
		
		return dao2.getallUpdatedCropsByBid(ubid);
	}
		
}
