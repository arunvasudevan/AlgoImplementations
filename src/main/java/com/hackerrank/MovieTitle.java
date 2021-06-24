package com.hackerrank;
/*
  https://stackoverflow.com/questions/48448432/fragment-of-missing-code-in-the-solution-movie-titles-complete-a-challenge-more/48656211

 */
import java.io.*;
import java.net.URL;
import java.util.*;
import java.net.HttpURLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class MovieTitle {
  /*
   * Complete the function below.
   */

  static String[] getMovieTitles(String substr) {

    List<String> list = new ArrayList<>();
    try{
      long page = 1, totalPage = 1;
      while(page <= totalPage) {
        String URL_STRING = "https://jsonmock.hackerrank.com/api/movies/search/?Title="+substr+"&page="+page;
        URL url = new URL(URL_STRING);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        BufferedReader buff = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String str;
        while( (str = buff.readLine()) != null) {
          JSONParser jsonParser = new JSONParser();
          JSONObject jsonObject = (JSONObject) jsonParser.parse(str);
          totalPage = (Long) jsonObject.get("total_pages");
          JSONArray jsonArray = (JSONArray) jsonObject.get("data");

          for (Object o : jsonArray) {
            JSONObject movie = (JSONObject) o;
            list.add((String) movie.get("Title"));
          }
        }
        page++;
      }
    } catch(Exception e) {
      e.printStackTrace();
    }

    Collections.sort(list);
    String[] output = new String[list.size()];
    for(int j = 0; j < list.size(); j++) {
      output[j] = list.get(j);
    }

    return output;
  }

  public static void main(String[] args) throws IOException{
    String[] res = getMovieTitles("spiderman");
    for (String re : res) {
      System.out.println(re);
    }
  }
}
