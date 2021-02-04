package com.cameronsmith.driverslicense.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronsmith.driverslicense.models.Person;
import com.cameronsmith.driverslicense.repositories.PersonRepo;

@Service
public class PersonService {
	@Autowired
	private PersonRepo pRepo;
	
	public List<Person> getAll(){
		return this.pRepo.findAll();
	}
	public Person createEntry(Person newEntry) {
		return this.pRepo.save(newEntry);
	}
	public Person createEntry(String firstName, String lastName) {
		Person newEntry = new Person(firstName, lastName);
		return this.pRepo.save(newEntry);
	}
	public Person getById(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	public Person updateEntry(Person toUpdate) {
		return this.pRepo.save(toUpdate);
	}
	public void deleteById(Long id) {
		this.pRepo.deleteById(id);
	}
}
