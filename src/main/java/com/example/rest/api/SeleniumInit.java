package com.example.rest.api;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class SeleniumInit {
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
			// String temp=user.toString();
			 list.add(movie);
		}
	//	 System.out.println(list);
		return list;
	}
}
