package com.cameronsmith.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronsmith.dojosandninjas.models.Dojo;
import com.cameronsmith.dojosandninjas.repositories.DojoRepo;

@Service
public class DojoService {
	@Autowired
	private DojoRepo dRepo;

	public List<Dojo> getAll(){
		return this.dRepo.findAll();
	}
	public Dojo createEntry(Dojo newEntry) {
		return this.dRepo.save(newEntry);
	}
	public Dojo createEntry(String name) {
		Dojo newEntry = new Dojo(name);
		return this.dRepo.save(newEntry);
	}
	public Dojo getById(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	public Dojo updateEntry(Dojo toUpdate) {
		return this.dRepo.save(toUpdate);
	}
	public void deleteById(Long id) {
		this.dRepo.deleteById(id);
	}
	
}
