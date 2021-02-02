package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.UpdateCropBuyer;

@Repository
public class UpadteCropBuyerImpl implements IUpdateCrop {

	
	@PersistenceContext
	private EntityManager mgr;

	public UpadteCropBuyerImpl() {
		System.out.println("in ctor of " + getClass().getName());
	}

	@Override
	public List<UpdateCropBuyer> getallUpdatedCropsByBid(int bid) {
		
		  System.out.println("in get update crops all ......"+bid); String
		  jpql="select u from UpdateCropBuyer u  where u.selectedBuyer.bid =: bid";
		  //String jpql=" select p from UpdateCropBuyer u where u.bid=:bid";
		  System.out.println(jpql); System.out.println("done....");
		  
		  return mgr.createQuery(jpql,UpdateCropBuyer.class).setParameter("bid",bid).
		  getResultList(); 
		 
			}

}
