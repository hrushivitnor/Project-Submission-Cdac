package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Credentials")
public class Credentials {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column (length=20,unique=true)
	private String userName;
	@Column(length = 20)
	private String password;
	@Column(length = 20)
	private String role;
	
	
		public Credentials() {
			System.out.println("in ctor of "+getClass().getName());
		}

		
	


	public Credentials(Integer id, String userName, String password, String role) {
			super();
			this.id = id;
			this.userName = userName;
			this.password = password;
			this.role = role;
		}



	@Override
	public String toString() {
		return "Credentials [id=" + id + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}

}
