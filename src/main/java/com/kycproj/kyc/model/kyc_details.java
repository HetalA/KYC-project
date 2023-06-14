package com.kycproj.kyc.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="kyc_details")
public class kyc_details {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name= "pos_agent_id")
	private int pos_agent_id;
	
	@Column(name= "mobile", nullable=true)
	private String mobile;
	
	@Column(name= "customer_type")
	private int customer_type;
	
	@Column(name= "company_name")
	private String company_name;
	
	@Column(name= "company_address")
	private String company_address;
	
	@Column(name= "company_doi")
	private String company_doi;
	
	@Column(name= "company_poi")
	private String company_poi;
	
	@Column(name= "gender")
	private int gender;
	
	@Column(name= "first_name")
	private String first_name;
	
	@Column(name= "middle_name")
	private String middle_name;
	
	@Column(name= "last_name")
	private String last_name;
	
	@Column(name= "nationality")
	private String nationality;
	
	@Column(name= "otp_language")
	private int otp_language;
	
	@Column(name= "alt_contact")
	private String alt_contact;
	
	@Column(name= "email")
	private String email;
	
	@Column(name= "mother_name")
	private String mother_name;
	
	@Column(name= "alt_no_holder_relation")
	private int alt_no_holder_relation;
	
	@Column(name= "DOB")
	private String DOB;
	
	@Column(name= "POI_type")
	private int POI_type;
	
	@Column(name= "POA_type")
	private int POA_type;
	
	@Column(name= "poi")
	private String poi;
	
	@Column(name= "poa")
	private String poa;
	
	@Column(name= "company_type")
	private int company_type;
	
	@Column(name= "POI_name")
	private String POI_name;
	
	@Column(name= "POA_name")
	private String POA_name;
	
	@Column(name= "status")
	private String status;
	
	@Column(name= "created_date")
	private String created_date;
	
	@Column(name= "modified_date")
	private String modified_date;
	
	@Column(name= "is_POI_uploaded")
	private boolean is_POI_uploaded;
	
	@Column(name= "is_POA_uploaded")
	private boolean is_POA_uploaded;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPos_agent_id() {
		return pos_agent_id;
	}

	public void setPos_agent_id(int pos_agent_id) {
		this.pos_agent_id = pos_agent_id;
	}


	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPoi() {
		return poi;
	}

	public void setPoi(String poi) {
		this.poi = poi;
	}

	public String getPoa() {
		return poa;
	}

	public void setPoa(String poa) {
		this.poa = poa;
	}

	public int getCustomer_type() {
		return customer_type;
	}

	public void setCustomer_type(int customer_type) {
		this.customer_type = customer_type;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCompany_address() {
		return company_address;
	}

	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}

	public String getCompany_doi() {
		return company_doi;
	}

	public void setCompany_doi(String company_doi) {
		this.company_doi = company_doi;
	}

	public String getCompany_poi() {
		return company_poi;
	}

	public void setCompany_poi(String company_poi) {
		this.company_poi = company_poi;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public int getOtp_language() {
		return otp_language;
	}

	public void setOtp_language(int otp_language) {
		this.otp_language = otp_language;
	}

	public String getAlt_contact() {
		return alt_contact;
	}

	public void setAlt_contact(String alt_contact) {
		this.alt_contact = alt_contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMother_name() {
		return mother_name;
	}

	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}

	public int getAlt_no_holder_relation() {
		return alt_no_holder_relation;
	}

	public void setAlt_no_holder_relation(int alt_no_holder_relation) {
		this.alt_no_holder_relation = alt_no_holder_relation;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public int getPOI_type() {
		return POI_type;
	}

	public void setPOI_type(int pOI_type) {
		POI_type = pOI_type;
	}

	public int getPOA_type() {
		return POA_type;
	}

	public void setPOA_type(int pOA_type) {
		POA_type = pOA_type;
	}




	public int getCompany_type() {
		return company_type;
	}

	public void setCompany_type(int company_type) {
		this.company_type = company_type;
	}

	public String getPOI_name() {
		return POI_name;
	}

	public void setPOI_name(String pOI_name) {
		POI_name = pOI_name;
	}

	public String getPOA_name() {
		return POA_name;
	}

	public void setPOA_name(String pOA_name) {
		POA_name = pOA_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getModified_date() {
		return modified_date;
	}

	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}

	public boolean isIs_POI_uploaded() {
		return is_POI_uploaded;
	}

	public void setIs_POI_uploaded(boolean is_POI_uploaded) {
		this.is_POI_uploaded = is_POI_uploaded;
	}

	@Override
	public String toString() {
		return "kyc_details [id=" + id + ", pos_agent_id=" + pos_agent_id + ", customer_mobile=" + mobile
				+ ", customer_type=" + customer_type + ", company_name=" + company_name + ", company_address="
				+ company_address + ", company_doi=" + company_doi + ", company_poi=" + company_poi + ", gender="
				+ gender + ", first_name=" + first_name + ", middle_name=" + middle_name + ", last_name=" + last_name
				+ ", nationality=" + nationality + ", otp_language=" + otp_language + ", alt_contact=" + alt_contact
				+ ", email=" + email + ", mother_name=" + mother_name + ", alt_no_holder_relation="
				+ alt_no_holder_relation + ", DOB=" + DOB + ", POI_type=" + POI_type + ", POA_type=" + POA_type
				+ ", POI_number=" + poi + ", POA_number=" + poa + ", company_type=" + company_type
				+ ", POI_name=" + POI_name + ", POA_name=" + POA_name + ", status=" + status + ", created_date="
				+ created_date + ", modified_date=" + modified_date + ", is_POI_uploaded=" + is_POI_uploaded
				+ ", is_POA_uploaded=" + is_POA_uploaded + "]";
	}

	public boolean isIs_POA_uploaded() {
		return is_POA_uploaded;
	}

	public void setIs_POA_uploaded(boolean is_POA_uploaded) {
		this.is_POA_uploaded = is_POA_uploaded;
	}


	
}
