package com.cameronsmith.lookify.controllers;

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

import com.cameronsmith.lookify.models.Song;
import com.cameronsmith.lookify.services.SongService;

@Controller
public class MasterController {
	@Autowired
	private SongService sService;
	
	@GetMapping("/")
	public String welcome() {
		return "index.jsp";
	}
	@GetMapping("/dashboard")
	public String dashBoard(@ModelAttribute("song")Song song, BindingResult result, Model viewModel) {
		List<Song> songList = sService.getAllSongs();
		viewModel.addAttribute("songList", songList);
		return "dashboard.jsp";
	}
	@GetMapping("/songs/new")
	public String renderAddSongJSP(@ModelAttribute("song")Song song) {
		return "addSong.jsp";
	}
	@PostMapping("/songs/new")
    public String createSong(@Valid @ModelAttribute("song")Song song, BindingResult result,Model viewModel) {
    		if (result.hasErrors()) {
            return "addSong.jsp";
        } 
        this.sService.createSong(song);
        return "redirect:/dashboard";
    }
	@GetMapping("/song/{id}")
	public String infoById(@PathVariable("id")Long id, Model viewModel) {
		Song song = sService.getById(id);
		viewModel.addAttribute("song", song);
		return "showSong.jsp";
	}
	@GetMapping("/song/{id}/delete")
	public String deleteSong(@PathVariable("id") Long id) {
		this.sService.deleteById(id);
		return "redirect:/dashboard";
	}
	@PostMapping("/search")
	public String getSongByArtist(@RequestParam("artist")String artist, Model viewModel) {
		List<Song> songList = sService.getSongByArtist(artist);
		viewModel.addAttribute("songList", songList);
		viewModel.addAttribute("artist", artist);
		return "showArtist.jsp";
	}
	@GetMapping("/topTen")
	public String topTen(Model viewModel) {
		List<Song> topTenList = sService.topTen();
		System.out.println(topTenList);
		viewModel.addAttribute("songs", sService.topTen());
		return "topTen.jsp";
	}
}
