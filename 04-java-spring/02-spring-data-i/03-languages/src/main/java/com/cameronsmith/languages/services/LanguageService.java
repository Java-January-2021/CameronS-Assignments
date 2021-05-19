package com.cameronsmith.languages.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronsmith.languages.models.Language;
import com.cameronsmith.languages.repositories.LanguageRepo;

@Service
public class LanguageService {
	@Autowired
	private LanguageRepo lRepo;
	
	public List<Language> getAllLanguages(){
		return this.lRepo.findAll();
	}
	public Language create(Language newLang) {
		return this.lRepo.save(newLang);
	}
	public Language createLang(String name, String creator, String version) {
		Language newLang = new Language(name,creator,version);
		return this.lRepo.save(newLang);
	}
	public Language getByID(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	public Language updateEntry(Language langToUpdate) {
		return this.lRepo.save(langToUpdate);
	}
	public void deleteByID(Long id) {
		this.lRepo.deleteById(id);
	}
}
