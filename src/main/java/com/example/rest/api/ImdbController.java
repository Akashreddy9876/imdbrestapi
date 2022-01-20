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
		SeleniumInit obj=new SeleniumInit(); 
		ArrayList<JSONObject> returnedMovies= obj.initialise_top_movies();
		
		JSONObject movies = new JSONObject();
		movies.put("movies", returnedMovies);
		
		return new ResponseEntity<>(movies.toMap(), HttpStatus.OK);
	}
}
