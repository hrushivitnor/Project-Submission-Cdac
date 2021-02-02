package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

@Entity
@Table(name="Updatecropbuyer")
public class UpdateCropBuyer {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ubid;
	private Double cropPrice;
	private String cropname;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate Date;

	//@JsonBackReference
	@JsonIgnoreProperties("crops")
	@ManyToOne
	@JoinColumn (name="bid",nullable=true)
	private Buyers selectedBuyer;
	

	//@JsonBackReference
	@JsonIgnoreProperties("crop")
	@OneToOne
	@JoinColumn(name="cropId",nullable=true)
	private Crop cropId;
	/*@ManyToOne
	@JoinColumn(name = "faculty_id")
	private Faculty courseFaculty;*/
	
	
	public UpdateCropBuyer() {
		System.out.println("in ctor of "+getClass().getName());
	}


	public Integer getUbid() {
		return ubid;
	}


	public void setUbid(Integer ubid) {
		this.ubid = ubid;
	}


	public Double getCropPrice() {
		return cropPrice;
	}


	public void setCropPrice(Double cropPrice) {
		this.cropPrice = cropPrice;
	}


	public String getCropname() {
		return cropname;
	}


	public void setCropname(String cropname) {
		this.cropname = cropname;
	}


	public LocalDate getDate() {
		return Date;
	}


	public void setDate(LocalDate date) {
		Date = date;
	}


	public Buyers getSelectedBuyer() {
		return selectedBuyer;
	}


	public void setSelectedBuyer(Buyers selectedBuyer) {
		this.selectedBuyer = selectedBuyer;
	}


	public Crop getCropId() {
		return cropId;
	}


	public void setCropId(Crop cropId) {
		this.cropId = cropId;
	}


	@Override
	public String toString() {
		return "UpdateCropBuyer [cropPrice=" + cropPrice + ", cropname=" + cropname + ", Date=" + Date
				+ ", selectedBuyer=" + selectedBuyer + ", cropId=" + cropId + "]";
	}
	
	

	
	
	
	
	
}
