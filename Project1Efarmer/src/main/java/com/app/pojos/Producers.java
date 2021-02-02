package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Producers")
public class Producers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer pid;
	@Column(length=30)
	private String pname;
	@Column(unique=true)
   private String emailId;
	@Column(length=30)
	private String address;
	private String district;
	private String city;
	private Integer Pincode;
	private String state;
	@Column(length=12)
	private Long  contactNo;
	private Long  accountNo;
	@Column(length=40)
	private String accountDetials;
	@Column(length=16,unique=true)
	private Long  aadharNo;
	@OneToMany(mappedBy = "selectedproducer",cascade = CascadeType.ALL)
	private List<Transaction> transactions;
	public Producers() {
		System.out.println("in ctor of "+getClass().getName());
	}

	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
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
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountDetials() {
		return accountDetials;
	}
	public void setAccountDetials(String accountDetials) {
		this.accountDetials = accountDetials;
	}
	public Long getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(Long aadharNo) {
		this.aadharNo = aadharNo;
	}

}
