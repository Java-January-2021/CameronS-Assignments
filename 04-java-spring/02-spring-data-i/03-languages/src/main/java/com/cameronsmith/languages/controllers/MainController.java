package com.cameronsmith.languages.controllers;

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
import com.cameronsmith.languages.models.Language;
import com.cameronsmith.languages.services.LanguageService;

@Controller
public class MainController {
	@Autowired
	private LanguageService lService;
	@GetMapping("/languages")
	public String index(@ModelAttribute("language")Language lang, Model viewModel) {
		List<Language> langList = lService.getAllLanguages();
		viewModel.addAttribute("langList",langList);
		return "index.jsp";
	}
	@PostMapping("/languages/addEntry")
    public String createBook(Model viewModel, @Valid @ModelAttribute("language")Language lang, BindingResult result) {
    		if (result.hasErrors()) {
    			List<Language> langList = lService.getAllLanguages();
    			viewModel.addAttribute("langList",langList);
            return "index.jsp";
        } 
        this.lService.createLang(lang);
        return "redirect:/languages";
    }
	@GetMapping("/languages/{id}")
	public String infoById(@PathVariable("id") Long id, Model viewModel) {
		Language lang = lService.getByID(id);
		viewModel.addAttribute("lang",lang);
		return "info.jsp";
	}
	@GetMapping("/languages/{id}/edit")
	public String editById(@ModelAttribute("language")Language language, @PathVariable("id") Long id, Model viewModel) {
		Language lang = lService.getByID(id);
			viewModel.addAttribute("lang",lang);
            return "edit.jsp";
       
	}
	@PostMapping("/languages/{id}/edit")
	public String updateEntry(@PathVariable("id") Long id, Model viewModel, @Valid @ModelAttribute("language")Language langToUpdate, BindingResult result) {
		Language lang = lService.getByID(id);
		if (result.hasErrors()) {
			viewModel.addAttribute("lang",lang);
            return "edit.jsp";
        }else {
        	this.lService.updateEntry(langToUpdate);
        	return "redirect:/languages/{id}";
        }
	}
	@GetMapping("/languages/{id}/delete")
	public String deleteEntry(@PathVariable("id") Long id) {
		this.lService.deleteByID(id);
		return "redirect:/languages";
	}
}
