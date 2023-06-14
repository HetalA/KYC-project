package com.kycproj.kyc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_details")
public class user_details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name= "name")
	private String name;
	
	@Column(name= "DOB")
	private String DOB;
	
	@Column(name= "utype")
	private int utype;
	
	@Column(name = "pid")
	private int pid;
	
	@Column(name = "user_id")
	private String user_id;
	
	public int getUtype() {
		return utype;
	}

	public void setUtype(int utype) {
		this.utype = utype;
	}

	public int getParent_id() {
		return pid;
	}

	public void setParent_id(int parent_id) {
		this.pid = parent_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Kyc [id=" + id + ", name=" + name + ", DOB=" + DOB + ", utype=" + utype + ", parent_id=" + pid
				+ ", user_id=" + user_id + "]";
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	
}
