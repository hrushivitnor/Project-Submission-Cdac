package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Buyers;




public interface IBuyerDao extends JpaRepository<Buyers, Integer> {
	//Optional<Buyers> findByCityName(String city);
	//List<Buyers>getAllBuyers();
//	Buyers getBuyerDetailsbyId(int bid);
//	Buyers addBuyer(Buyers transientBuyer);
//	Buyers UpdateBuyer(Buyers detachedPojo);
	//Buyers deleteBuyer(int bid);



	
	
}
