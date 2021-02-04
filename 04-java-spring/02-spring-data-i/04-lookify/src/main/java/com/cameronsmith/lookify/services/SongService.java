package com.cameronsmith.lookify.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronsmith.lookify.models.Song;
import com.cameronsmith.lookify.repositories.SongRepo;

@Service
public class SongService {
	@Autowired
	private SongRepo sRepo;
	public List<Song> getAllSongs(){
		return this.sRepo.findAll();
	}
	public List<Song> getSongByArtist(String artist){
		return this.sRepo.findByArtistContaining(artist);
	}
	public Song createSong(Song newSong) {
		return this.sRepo.save(newSong);
	}
	public Song createSong(String name, String artist, int rating) {
		Song newSong = new Song(name, artist, rating);
		return this.sRepo.save(newSong);
	}
	public Song getById(Long id) {
		return this.sRepo.findById(id).orElse(null);
	}
	public Song updateSong(Song songToUpdate) {
		return this.sRepo.save(songToUpdate);
	}
	public void deleteById(Long id) {
		this.sRepo.deleteById(id);
	}
	public List<Song> topTen(){
		return this.sRepo.findTop10ByOrderByRatingDesc();
	}
}
