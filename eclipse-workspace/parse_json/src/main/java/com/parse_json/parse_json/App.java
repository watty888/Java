package com.parse_json.parse_json;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.parse_json.parse_json.MoviesAnalyzer.Movie;
import com.parse_json.parse_json.MoviesAnalyzer.User;

public class App {
	public static void main( String[] args ) throws IOException {
		

		InputStream in = new FileInputStream("/Users/watty_/Desktop/java zadacka s testa/movies.json");
		InputStream in2 = new FileInputStream("/Users/watty_/Desktop/java zadacka s testa/users.json");

		
		JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
		JsonReader reader2 = new JsonReader(new InputStreamReader(in2, "UTF-8"));

		
				Gson gson = new Gson();
				Gson gson2 = new Gson();

		        List<Movie> mov = new ArrayList<Movie>();
		        List<User> usr = new ArrayList<User>();

		        reader.beginArray();
		        while (reader.hasNext()) {
		            Movie movv = gson.fromJson(reader, Movie.class);
		            mov.add(movv);
		        }
		        reader.endArray();
		        reader.close();
		        
		        reader2.beginArray();
		        while (reader2.hasNext()) {
		            User usr2 = gson2.fromJson(reader2, User.class);
		            usr.add(usr2);
		        }
		        reader2.endArray();
		        reader2.close();
		        
		 MoviesAnalyzer mv = new MoviesAnalyzer(mov, usr);
		        System.out.println(mv);
	}
}
