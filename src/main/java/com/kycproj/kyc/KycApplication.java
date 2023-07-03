package com.kycproj.kyc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
public class KycApplication {

	public static void main(String[] args) {
		SpringApplication.run(KycApplication.class, args);
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	   {
	      registry.addResourceHandler("/**").addResourceLocations(
	            "classpath:/images/POA-photos",
	            "classpath:/images/POI-photos");
	   }

}
