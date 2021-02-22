package com.cameronsmith.driverslicense.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronsmith.driverslicense.models.License;
import com.cameronsmith.driverslicense.repositories.LicenseRepo;

@Service
public class LicenseService {
	@Autowired
	private LicenseRepo lRepo;
	
	public List<License> getAll(){
		return this.lRepo.findAll();
	}
	public License createLicense(License newEntry) { 
		return this.lRepo.save(newEntry);
	}
	public License getById(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	public License updateEntry(License toUpdate) {
		return this.lRepo.save(toUpdate);
	}
	public void deleteById(Long id) {
		this.lRepo.deleteById(id);
	}
	public Long generateLicenseNum() {
		Long count = null;
		
		return  count;
	}
}
