package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transportation")
public class Transport {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tcId;
	@Column(length=30)
	private String cName;
	@Column(length=30)
	private String address;
	@Column(length=12)
	private Long contactNo;
	@Column(length=20)
	private String city;
	@Column(length=20)
	private Integer pricePerKm;
	public Transport() {
		System.out.println("in ctor of "+getClass().getName());
	}

	
	

	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	public Integer getPricePerKm() {
		return pricePerKm;
	}




	public void setPricePerKm(Integer pricePerKm) {
		this.pricePerKm = pricePerKm;
	}




	@Override
	public String toString() {
		return "Transport [tcId=" + tcId + ", cName=" + cName + ", address=" + address + ", contactNo=" + contactNo
				+ ", city=" + city + ", pricePerKm=" + pricePerKm + "]";
	}




	public Integer getTcId() {
		return tcId;
	}

	public void setTcId(Integer tcId) {
		this.tcId = tcId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}


}
