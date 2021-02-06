package com.cameronsmith.dojosandninjas.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.cameronsmith.dojosandninjas.models.Dojo;
import com.cameronsmith.dojosandninjas.models.Ninja;
import com.cameronsmith.dojosandninjas.services.DojoService;
import com.cameronsmith.dojosandninjas.services.NinjaService;

@Controller
public class MainController {
	@Autowired
	private DojoService dService;
	@Autowired
	private NinjaService nService;
	@GetMapping("/")
	public String index() {
		return "index.jsp";		
	}
	@PostMapping("/")
	public String dojoInfo(@RequestParam("id")Long id) {
		System.out.println(id);
		return "redirect:/dojo/"+id;
	}
	@GetMapping("/dojo/{id}")
	public String showInfo(@PathVariable("id")Long id, Model viewModel) {
		Dojo thisDojo = dService.getById(id);
		List<Ninja> ninjas = thisDojo.getNinjas();
		viewModel.addAttribute("dojo", thisDojo);
		viewModel.addAttribute("ninjas", ninjas);
		return "dojoInfo.jsp";
	}
	@GetMapping("/dojo/new")
	public String newDojo(@ModelAttribute("dojo")Dojo dojo, BindingResult result) {
		return "newDojo.jsp";
	}
	@PostMapping("/dojo/new")
	public String createDojo(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "newDojo.jsp";
		}
		this.dService.createEntry(dojo);
		return "redirect:/dojo/new";
	}
	@GetMapping("/ninja/new")
	public String newNinja(@ModelAttribute("ninja")Ninja ninja, BindingResult result, Model viewModel) {
		List<Dojo> allDojo = dService.getAll();
		viewModel.addAttribute("allDojos", allDojo);
		return "newNinja.jsp";
	}
	@PostMapping("/ninja/new")
	public String createNinja(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "newNinja.jsp";
		}
		this.nService.createEntry(ninja);
		return "redirect:/ninja/new";
	}
}
