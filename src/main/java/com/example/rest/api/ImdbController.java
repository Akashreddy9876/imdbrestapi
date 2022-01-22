package com.example.rest.api;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ImdbController {
	@RequestMapping("/")
	public String initialise() {
		return "API has been initialised...";
	}
	@RequestMapping("/topmovies")
	public ResponseEntity<Object> topmovies() throws IOException {
		JsoupInit obj=new JsoupInit(); 
		ArrayList<JSONObject> returnedMovies= obj.initialise_top_movies();
		
		JSONObject topmovies = new JSONObject();
		topmovies.put("movies", returnedMovies);
		
		return new ResponseEntity<>(topmovies.toMap(), HttpStatus.OK);
	}
	@RequestMapping("/mostpopular")
	public ResponseEntity<Object> mostpopular() throws IOException {
		JsoupInit obj=new JsoupInit(); 
		ArrayList<JSONObject> returnedMovies= obj.initialise_most_popular();
		JSONObject popularmovies = new JSONObject();
		popularmovies.put("movies", returnedMovies);
		
		return new ResponseEntity<>(popularmovies.toMap(), HttpStatus.OK);
	}
	@RequestMapping("/topboxoffice")
	public ResponseEntity<Object> topboxoffice() throws IOException {
		JsoupInit obj=new JsoupInit(); 
		ArrayList<JSONObject> returnedMovies= obj.initialise_top_box_office();
		JSONObject topbomovies = new JSONObject();
		topbomovies.put("movies", returnedMovies);
		
		return new ResponseEntity<>(topbomovies.toMap(), HttpStatus.OK);
	}
}
