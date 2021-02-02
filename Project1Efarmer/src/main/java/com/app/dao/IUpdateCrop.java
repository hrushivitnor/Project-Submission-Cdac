package com.app.dao;
import java.util.List;

import com.app.pojos.UpdateCropBuyer;
public interface IUpdateCrop {
	
	public	List<UpdateCropBuyer> getallUpdatedCropsByBid(int ubid);
}
