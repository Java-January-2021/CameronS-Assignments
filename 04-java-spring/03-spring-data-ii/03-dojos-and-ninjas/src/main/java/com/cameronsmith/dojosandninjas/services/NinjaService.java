package com.cameronsmith.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronsmith.dojosandninjas.models.Ninja;
import com.cameronsmith.dojosandninjas.repositories.NinjaRepo;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepo nRepo;

	public List<Ninja> getAll(){
		return this.nRepo.findAll();
	}
	public Ninja createEntry(Ninja newEntry) {
		return this.nRepo.save(newEntry);
	}
	public Ninja createEntry(String firstname, String lastname, int age) {
		Ninja newEntry = new Ninja(firstname, lastname, age);
		return this.nRepo.save(newEntry);
	}
	public Ninja getById(Long id) {
		return this.nRepo.findById(id).orElse(null);
	}
	public Ninja updateEntry(Ninja toUpdate) {
		return this.nRepo.save(toUpdate);
	}
	public void deleteById(Long id) {
		this.nRepo.deleteById(id);
	}
	
}
