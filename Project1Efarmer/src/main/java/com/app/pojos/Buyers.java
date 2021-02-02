package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="Buyers")
public class Buyers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private Integer bid;
	@Column(length=30)
	private String bname;
	@Column(unique=true)
   private String emailId;
	@Column(length=80)
	private String address;
	@Column(length=20)
	private String district;
	@Column(length=20)
	private String city;
	@Column(length=8)
	private Integer Pincode;
	@Column(length=20)
	private String state;
	@Column(length=12,unique=true)
	private Long contactNo;
	@Column(length=20)
	private Long  accountNo;
	@Column(length=16,unique=true)
	private Long  aadharNo;
	@Column(length=25)
	private String licenceType;
 
	//@OneToMany(name="bid",nullable=true)
	//private UpdateCropBuyer updateCropBuyer;
//@JsonManagedReference selectedBuyer
   @JsonIgnoreProperties("selectedBuyer")
	@OneToMany(mappedBy = "selectedBuyer",cascade = CascadeType.REMOVE,orphanRemoval = true,fetch = FetchType.EAGER)
	private List<UpdateCropBuyer> crops;


/*@JsonManagedReference 
@Cascade(org.hibernate.annotations.CascadeType.DELETE)
@JsonIgnoreProperties("buyers")
	@OneToMany(mappedBy = "selectedBuyer",cascade = CascadeType.REMOVE,orphanRemoval = true,fetch=FetchType.LAZY)
	private List<Transaction> transactions;
	*/








	public List<UpdateCropBuyer> getCrops() {
	return crops;
}

public void setCrops(List<UpdateCropBuyer> crops) {
	this.crops = crops;
}

	public Buyers() {
		System.out.println("in ctor of "+getClass().getName());
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPincode() {
		return Pincode;
	}

	public void setPincode(Integer pincode) {
		Pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long acccountNo) {
		this.accountNo = acccountNo;
	}
	public Long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(Long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getLicenceType() {
		return licenceType;
	}

	public void setLicenceType(String licenceType) {
		this.licenceType = licenceType;
	}

	@Override
	public String toString() {
		return "Buyers [bid=" + bid + ", bname=" + bname + ", emailId=" + emailId + ", address=" + address
				+ ", district=" + district + ", city=" + city + ", Pincode=" + Pincode + ", state=" + state
				+ ", contactNo=" + contactNo + ", acccountNo=" + accountNo + ", aadharNo=" + aadharNo
				+ ", licenceType=" + licenceType + "]";
	}

}
