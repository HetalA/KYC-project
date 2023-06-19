package com.kycproj.kyc.repository;

import org.springframework.data.repository.CrudRepository;

import com.kycproj.kyc.model.kyc_details;
import com.kycproj.kyc.model.user_details;

public interface AllDetailsRepository extends CrudRepository<kyc_details,Integer>{


	boolean existsByMobile(String mobile);

	boolean existsByPoa(String pOA_no);

	boolean existsByPoi(String pOI_no);

	kyc_details getById(int id);
	
	

}
