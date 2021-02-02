package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.UpdateCropBuyer;

public interface IUpdateCropBuyerDao extends JpaRepository<UpdateCropBuyer, Integer> {

	//List<UpdateCropBuyer> findBySelectedBuyer(int bid);

	List<UpdateCropBuyer> findAllBySelectedBuyer(int bid);

//public	List<UpdateCropBuyer> getallUpdatedCropsByBid(int bid);
}
