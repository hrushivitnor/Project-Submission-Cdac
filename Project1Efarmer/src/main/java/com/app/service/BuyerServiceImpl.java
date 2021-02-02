package com.app.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.app.dao.IBuyerDao;
import com.app.dao.IUpdateCropBuyerDao;
import com.app.pojos.Buyers;
import com.app.pojos.UpdateCropBuyer;


@Service
@Transactional
public class BuyerServiceImpl implements IBuyerService  {
	@Autowired
	private IBuyerDao dao;
	private IUpdateCropBuyerDao updateCropRepo;
	public BuyerServiceImpl() {
		System.out.println("in ctor of " + getClass().getName());
	}

	@Override
	public List<Buyers> getAllBuyers() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	
	

	@Override
	public Buyers addBuyer(Buyers transientBuyer) {
		// TODO Auto-generated method stub
		return dao.save(transientBuyer);
	}

	@Override
	public Optional<Buyers> getBuyerDetailsbyId(int bid) {
		// TODO Auto-generated method stub
		return dao.findById(bid);
	}

	@Override
	public Buyers UpdateBuyer(int bid,Buyers detachedPojo) {
		System.out.println("in update buyer service");
		Optional<Buyers> existingBuyer=dao.findById(bid);
		if(existingBuyer.isPresent())
		{
			Buyers buyer=existingBuyer.get();
			buyer.setContactNo(detachedPojo.getContactNo());
			buyer.setBname(detachedPojo.getBname());
			buyer.setCity(detachedPojo.getCity());
			buyer.setDistrict(detachedPojo.getDistrict());
			buyer.setEmailId(detachedPojo.getEmailId());
			buyer.setAddress(detachedPojo.getAddress());
			buyer.setAadharNo(detachedPojo.getAadharNo());
			buyer.setAccountNo(detachedPojo.getAccountNo());
			buyer.setPincode(detachedPojo.getPincode());
			buyer.setState(detachedPojo.getState());
			buyer.setLicenceType(detachedPojo.getLicenceType());
		return buyer;
		}
		return null;
		
	}

	@Override
	public String deleteBuyerById(int bid) {
		System.out.println("in delete service"+bid);
		dao.deleteById(bid);
		return null;				
	}

	@Override
	public UpdateCropBuyer addCropBuyer(UpdateCropBuyer c) {
		updateCropRepo.save(c);
		return c;
	}



}
