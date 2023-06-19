package com.kycproj.kyc.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kycproj.kyc.model.FilesUpload;
import com.kycproj.kyc.model.kyc_details;
import com.kycproj.kyc.model.user_details;
import com.kycproj.kyc.services.KycService;

@Controller
@RequestMapping("/kyc")
public class KController {
	@Autowired
	KycService kservice;
	
	@ResponseBody
	@GetMapping("/getAllInfo/{parent_id}")
	public List<user_details> getInfo(@PathVariable("parent_id") int pid) {
		System.out.println("Parent :"+pid);
		List<user_details> list = kservice.findNamesFromParent_id(pid);
		System.out.println(list.toString());
		return list;
	}
	
	@ResponseBody
	@GetMapping("/getAllOE")
	public List<user_details> getAllOE() {
		List<user_details> list = kservice.findNamesFromType(1);
		return list;
	}
	
	@GetMapping("/form")
	public String showForm(Model model) {
		List<user_details> oe = getAllOE();
		model.addAttribute("OE",oe);
		kyc_details kyc = new kyc_details();
		model.addAttribute("kyc", kyc);
		System.out.println(kyc);
		return "formOpen";
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		kyc_details kyc = new kyc_details();
		model.addAttribute("kyc", kyc);
		return "savedSuccess";
	}
	
	
	@PostMapping("/save")
	public String saved(@ModelAttribute("kyc") kyc_details kyc, Model model) {
		String mobile = kyc.getMobile();
		String POI_no = kyc.getPoi();
		String POA_no = kyc.getPoa();
		if(kservice.existsByMobile(mobile))
		{
			model.addAttribute("duplicateMobile","Mobile number already exists.");
			return "redirect:/kyc/form";
		}
		if(kservice.existsByPOA(POA_no))
		{
			model.addAttribute("existingPOA", "POA number already exists.");
			return "formOpen";
		}
		if(kservice.existsByPOI(POI_no))
		{
			model.addAttribute("existingPOI","POI number already exists.");
			return "formOpen";
		}
		kservice.add(kyc);
		return "redirect:/kyc/display";
	}
	

	@GetMapping("/display")
	public String getKycDetails(Model model) 
	{
		List<kyc_details> details = kservice.getAllApplicants();
		model.addAttribute("details",details);
		return "savedSuccess";
	}
	
	@GetMapping("/uploadi/{id}")
	public String uploadi(@PathVariable("id") int id)
	{
		return "docUploadForm";
	}
	
	@GetMapping("/uploada/{id}")
	public String uploada(@PathVariable("id") int id)
	{
		return "poaUploadForm";
	}
	
	@PostMapping("/savePoi/{id}")
	public String savePhoto(@RequestParam("image") MultipartFile mpf, @PathVariable("id") int id) throws IOException{
		
		String filename = StringUtils.cleanPath(mpf.getOriginalFilename());
		System.out.println(filename);
		System.out.println(id);
		kyc_details kyc = new kyc_details();
		kyc.setPOI_name(filename);
		kyc.setIs_POI_uploaded(true);
		
		kyc_details savedPOI = kservice.savePOI(filename,id);
		try {
		String upload = "POI-photos/" + savedPOI.getId();
		FilesUpload.saveFile(upload,filename,mpf);
		}
		catch(IOException e)
		{
			System.out.println(e);
		};
		return "redirect:/kyc/display";
	}
	
	@PostMapping("/savePoa/{id}")
	public String saveProofAddr(@RequestParam("image") MultipartFile mpf, @PathVariable("id") int id) throws IOException{
		//System.out.println("controller");
		
		String filename = StringUtils.cleanPath(mpf.getOriginalFilename());
		System.out.println(filename);
		//System.out.println(kyc);
		//int id = kyc.getId();
		System.out.println(id);
		kyc_details kyc = new kyc_details();
		kyc.setPOA_name(filename);
		kyc.setIs_POA_uploaded(true);
		
		kyc_details savedPOA = kservice.savePOA(filename,id);
		try {
		String upload = "POA-photos/" + savedPOA.getId();
		FilesUpload.saveFile(upload,filename,mpf);
		}
		catch(IOException e)
		{
			System.out.println(e);
		};
		return "redirect:/kyc/display";
	}
	
	@ResponseBody
	@GetMapping("checkPOA/{id}")
	public boolean checkIfPoa(@ModelAttribute("item") kyc_details kyc)
	{
		System.out.println(kyc);
		boolean POA_exist = kyc.isIs_POA_uploaded();
		if(POA_exist)
		{
			return true;
		}
		return false;
	}
	
	@ResponseBody
	@GetMapping("checkPOI/{id}")
	public boolean checkIfPoi(@ModelAttribute("item") kyc_details kyc)
	{
		boolean POI_exist = kyc.isIs_POI_uploaded();
		if(POI_exist)
		{
			return true;
		}
		return false;
	}
	
	@GetMapping("view/{id}")
	public String view(@PathVariable("id") int id, Model model)
	{
		kyc_details kyc = kservice.getApplicantById(id);
		model.addAttribute("kyc",kyc);
		System.out.println(kyc);
		return "customerView";
	}
	
	@GetMapping("menu")
	public String home()
	{
		return "homepage";
	}
}
