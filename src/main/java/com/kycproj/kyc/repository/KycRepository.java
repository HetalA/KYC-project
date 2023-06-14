package com.kycproj.kyc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kycproj.kyc.model.user_details;
import com.kycproj.kyc.model.User_type;

@Repository
public interface KycRepository extends CrudRepository<user_details,Integer>{

	List<user_details> findByUtype(int utype);

	List<user_details> findByPid(int utype);
	
}
