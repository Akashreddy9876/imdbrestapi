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
	//TODO checking the api
	@RequestMapping("/")
	public String initialise() {
		return "API has been initialised...";
	}
	//TODO endpoint for top movies
	@RequestMapping("/topmovies")
	public ResponseEntity<Object> topmovies() throws IOException {
		JsoupInit obj=new JsoupInit(); 
		ArrayList<JSONObject> returnedMovies= obj.initialise_top_movies();
		
		JSONObject topmovies = new JSONObject();
		topmovies.put("topmovies", returnedMovies);
		
		return new ResponseEntity<>(topmovies.toMap(), HttpStatus.OK);
	}
	//TODO endpoint for most popular movies
	@RequestMapping("/popularmovies")
	public ResponseEntity<Object> popularmovies() throws IOException {
		JsoupInit obj=new JsoupInit(); 
		ArrayList<JSONObject> returnedMovies= obj.initialise_popular_movies();
		JSONObject popularmovies = new JSONObject();
		popularmovies.put("popularmovies", returnedMovies);
		
		return new ResponseEntity<>(popularmovies.toMap(), HttpStatus.OK);
	}
	//TODO endpoint for top box office movies
	@RequestMapping("/topboxoffice")
	public ResponseEntity<Object> topboxoffice() throws IOException {
		JsoupInit obj=new JsoupInit(); 
		ArrayList<JSONObject> returnedMovies= obj.initialise_top_box_office();
		JSONObject topbomovies = new JSONObject();
		topbomovies.put("topbomovies", returnedMovies);
		
		return new ResponseEntity<>(topbomovies.toMap(), HttpStatus.OK);
	}
	//TODO endpoint for top shows
		@RequestMapping("/topshows")
		public ResponseEntity<Object> topshows() throws IOException {
			JsoupInit obj=new JsoupInit(); 
			ArrayList<JSONObject> returnedshows= obj.initialise_top_shows();
			
			JSONObject topshows = new JSONObject();
			topshows.put("topshows", returnedshows);
			
			return new ResponseEntity<>(topshows.toMap(), HttpStatus.OK);
		}
		//TODO endpoint for most popular movies
		@RequestMapping("/popularshows")
		public ResponseEntity<Object> popularshows() throws IOException {
			JsoupInit obj=new JsoupInit(); 
			ArrayList<JSONObject> returnedshows= obj.initialise_popular_shows();
			JSONObject popularshows = new JSONObject();
			popularshows.put("popularmovies", returnedshows);
			
			return new ResponseEntity<>(popularshows.toMap(), HttpStatus.OK);
		}
	
}
