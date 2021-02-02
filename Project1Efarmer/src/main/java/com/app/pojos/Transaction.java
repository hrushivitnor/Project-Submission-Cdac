package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tid;
	
	
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate dot;
	private Double totalAmount;
	private Double cropPricePerUnit;
	private boolean status;
	
	@Override
	public String toString() {
		return "Transaction [tid=" + tid + ", dot=" + dot + ", totalAmount=" + totalAmount + ", cropPricePerUnit="
				+ cropPricePerUnit + ", status=" + status + ", bname=" + bname + "]";
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public LocalDate getDot() {
		return dot;
	}
	public void setDot(LocalDate dot) {
		this.dot = dot;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Double getCropPricePerUnit() {
		return cropPricePerUnit;
	}
	public void setCropPricePerUnit(Double cropPricePerUnit) {
		this.cropPricePerUnit = cropPricePerUnit;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	@Column(length=30)
	private String bname;
	@ManyToOne
	@JoinColumn (name="cropId",nullable=true)
	private Crop selectedcrop;
	@ManyToOne
	@JoinColumn (name="pid",nullable=true)
	private Producers selectedproducer;
/*@ManyToOne
	@JoinColumn (name="bid",nullable=true)
	private Buyers selectedBuyer;*/
	public Transaction() {
		System.out.println("in ctor of "+getClass().getName());
	}

}
