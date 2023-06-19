package com.kycproj.kyc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kycproj.kyc.model.user_details;
import com.kycproj.kyc.model.User_type;
import com.kycproj.kyc.model.kyc_details;
import com.kycproj.kyc.repository.KycRepository;
import com.kycproj.kyc.repository.AllDetailsRepository;

@Service
@Transactional
public class KycServiceImpl implements KycService{
	@Autowired
	KycRepository kycrepo;
	@Autowired
	AllDetailsRepository detailsrepo;
	
	public <S extends user_details> S save(S entity) {
		return kycrepo.save(entity);
	}
	public Optional<user_details> findById(Integer id) {
		return kycrepo.findById(id);
	}
	public boolean existsById(Integer id) {
		return kycrepo.existsById(id);
	}
//	public Iterable<user_details> findAll() {
//		return kycrepo.findAll();
//	}
	
	@Override
	public List<kyc_details> getAllApplicants(){
		return (List<kyc_details>)detailsrepo.findAll();
	}
	
	@Override
	public kyc_details getApplicantById(int id){
		return detailsrepo.getById(id);
	}
	
	public void deleteById(Integer id) {
		kycrepo.deleteById(id);
	}
	public void delete(user_details entity) {
		kycrepo.delete(entity);
	}
	public void deleteAll(Iterable<? extends user_details> entities) {
		kycrepo.deleteAll(entities);
	}
	@Override
	public List<user_details> getAllInfo(){
		return (List<user_details>)kycrepo.findAll();
	}
	
	@Override
	public List<user_details> findNamesFromType(int utype) {
		return kycrepo.findByUtype(utype);
	}
	@Override
	public List<user_details> findNamesFromParent_id(int utype) {
		// TODO Auto-generated method stub
		return kycrepo.findByPid(utype);
	}
	
	@Override
	public void add(kyc_details kyc) {
		detailsrepo.save(kyc);
	}
	
	@Override
	public kyc_details savePOI(String filename, int id) {
		kyc_details kyc = detailsrepo.findById(id).get();
		kyc.setPOI_name(filename);
		return detailsrepo.save(kyc);
	}
	
	@Override
	public kyc_details savePOA(String filename, int id) {
		kyc_details kyc = detailsrepo.findById(id).get();
		kyc.setPOA_name(filename);
		return detailsrepo.save(kyc);
	}

	@Override
	public boolean existsByMobile(String mobile) {
		return detailsrepo.existsByMobile(mobile);	
	}
	@Override
	public boolean existsByPOA(String pOA_no) {
		return detailsrepo.existsByPoa(pOA_no);
	}
	@Override
	public boolean existsByPOI(String pOI_no) {
		return detailsrepo.existsByPoi(pOI_no);
	}

}
