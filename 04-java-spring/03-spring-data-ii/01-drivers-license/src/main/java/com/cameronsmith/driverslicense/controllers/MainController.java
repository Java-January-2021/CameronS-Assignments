package com.cameronsmith.driverslicense.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cameronsmith.driverslicense.models.License;
import com.cameronsmith.driverslicense.models.Person;
import com.cameronsmith.driverslicense.services.LicenseService;
import com.cameronsmith.driverslicense.services.PersonService;

@Controller
public class MainController {
	@Autowired
	private PersonService pService;
	@Autowired
	private LicenseService lService;
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	@GetMapping("/person/new")
	public String newPerson(@ModelAttribute("person")Person person) {
		return "newPerson.jsp";
	}
	@PostMapping("/person/add")
    public String createObject(@Valid @ModelAttribute("person")Person person, BindingResult result) {
		if (result.hasErrors()) {
            return "newPerson.jsp";
        } 
        this.pService.createEntry(person);
        return "redirect:/person/new";
    }
	@GetMapping("/license/new")
	public String newLicense(@ModelAttribute("license")License license, Model viewModel) {
		List<Person> allPeople = pService.getAll();
		viewModel.addAttribute("allPeople", allPeople);
		return "newLicense.jsp";
	}
	@PostMapping("/license/add")
	public String createObject(@Valid @ModelAttribute("license")License license, BindingResult result) {
		if (result.hasErrors()) {
            return "newLicense.jsp";
        }
		this.lService.createLicense(license);
		return "redirect:/license/new";
	}
	@GetMapping("/person/{id}")
	public String showInfo( @PathVariable("id")Long id, Model viewModel) {
		Person person = pService.getById(id);
		License license = person.getLicense();
		if( license != null) {			
			Date expdate = license.getExpirationDate();
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat dateOnly = new SimpleDateFormat(pattern);
			String dateInput = dateOnly.format(expdate);
			viewModel.addAttribute("person", person);
			viewModel.addAttribute("license", license);
			viewModel.addAttribute("expDate", dateInput);
			return "showInfo.jsp";
		}else {
			viewModel.addAttribute("person", person);
			return "showInfo.jsp";
		}
	}
}
