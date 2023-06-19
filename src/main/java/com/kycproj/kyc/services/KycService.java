package com.kycproj.kyc.services;

import java.util.List;
import java.util.Optional;

import com.kycproj.kyc.model.user_details;
import com.kycproj.kyc.model.User_type;
import com.kycproj.kyc.model.kyc_details;

public interface KycService {

	List<user_details> getAllInfo();
	List<user_details> findNamesFromType(int utype);
	List<user_details> findNamesFromParent_id(int utype);
	List<kyc_details> getAllApplicants();
	void add(kyc_details kyc);
	kyc_details savePOI(String filename, int id);
	kyc_details savePOA(String filename, int id);
	boolean existsByMobile(String mobile);
	boolean existsByPOA(String pOA_no);
	boolean existsByPOI(String pOI_no);
	kyc_details getApplicantById(int id);

}
