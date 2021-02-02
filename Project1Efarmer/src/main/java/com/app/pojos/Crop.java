package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="CropAdmin")
public class Crop {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	

	private Integer cropId;
	private String cropName;
	@OneToOne

	//@JsonManagedReference 
   @JsonIgnoreProperties("cropId")
	private UpdateCropBuyer crop;
	@OneToMany(mappedBy = "selectedcrop",cascade = CascadeType.ALL)
	private List<Transaction> transactions;
	
	public Crop() {
		System.out.println("in ctor of "+getClass().getName());
	}

	
	@Override
	public String toString() {
		return "Crop [cropId=" + cropId + ", cropName=" + cropName 
				+ "]";
	}


	public Integer getCropId() {
		return cropId;
	}
	public void setCropId(Integer cropId) {
		this.cropId = cropId;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	
	
}
