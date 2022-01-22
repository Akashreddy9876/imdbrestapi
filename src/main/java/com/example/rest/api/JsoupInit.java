package com.example.rest.api;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class JsoupInit {
	//TODO top 250 movies
	public ArrayList<JSONObject> initialise_top_movies() throws IOException{ 
		ArrayList<JSONObject> list=new ArrayList<JSONObject>();
		Document doc = Jsoup.connect("https://www.imdb.com/chart/top/?ref_=nv_mv_250").get();
		Elements elements=doc.select("tbody.lister-list");
		for(Element e:elements.select("tr")) {
			 var movie = new JSONObject();
			 int rank = Integer.parseInt(e.select("td.titleColumn").text().split(" ")[0].replaceAll("\\p{Punct}", ""));
			 int year = Integer.parseInt(e.select("td.titleColumn span.secondaryInfo").text().replaceAll("[\\[\\](){}]",""));
			 float rating = Float.parseFloat(e.select("td.ratingColumn.imdbRating strong").text());
			 String title = e.select("td.titleColumn a").text();
			 movie.put("Rank", rank);
			 movie.put("Title",title);
			 movie.put("Year",year);
			 movie.put("Rating",rating);
			 list.add(movie);
		}
		return list;
	}
	//TODO most popular movies
	public ArrayList<JSONObject> initialise_most_popular() throws IOException{ 
		ArrayList<JSONObject> list=new ArrayList<JSONObject>();
		Document doc = Jsoup.connect("https://www.imdb.com/chart/moviemeter/?ref_=nv_mv_mpm").get();
		Elements elements=doc.select("tbody.lister-list");
		for(Element e:elements.select("tr")) {
			 var movie = new JSONObject();
			int rank = Integer.parseInt(e.select("td.titleColumn div.velocity").text().split(" ")[0]);
			 int year = Integer.parseInt(e.select("td.titleColumn span.secondaryInfo").text().replaceAll("[()]", "").split(" ")[0]);
			 String ratingg=e.select("td.imdbRating.ratingColumn strong").text().length()==0?"0":e.select("td.imdbRating.ratingColumn strong").text();
			 Float rating=Float.parseFloat(ratingg);
			 String title = e.select("td.titleColumn a").text();
			 movie.put("Rank", rank);
			 movie.put("Title",title);
			 movie.put("Year",year);
			 movie.put("Rating",rating);
			 list.add(movie);
		}
		return list;
	}
	//TODO top box office movies
	public ArrayList<JSONObject> initialise_top_box_office() throws IOException{ 
		ArrayList<JSONObject> list=new ArrayList<JSONObject>();
		Document doc = Jsoup.connect("https://www.imdb.com/chart/boxoffice/?ref_=nv_ch_cht").get();
		Elements elements=doc.select("tbody");
		for(Element e:elements.select("tr")) {
			 var movie = new JSONObject();
			 int weeks = Integer.parseInt(e.select("td.weeksColumn").text());
			 String weekend = e.select("td.ratingColumn").text().split(" ")[0];
			 String gross=e.select("td.ratingColumn span.secondaryInfo").text();
			 String title = e.select("td.titleColumn a").text();
			 movie.put("Weeks",weeks);
			 movie.put("Weekend",weekend);
			 movie.put("Gross",gross);
			 movie.put("Title",title);
			 list.add(movie);
		}
		return list;
	}
}
