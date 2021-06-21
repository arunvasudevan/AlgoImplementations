package com.outdoorsy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.parser.*;
import org.json.simple.*;
import java.io.*;

/*
    Outdoorsy HackerRank Coding Interview:

    Given an API “https://jsonmock.hackerrank.com/api/articles?author=epaga&page=1”

    Schema of the JSON Response:
      page
      per_page
      total
      total_pages
      data  - JSONArray

    Article table contains the following fields:
    Author
        title
        story_title
        author

    Write the method getTitlesByAuthor based on the below conditions:
    Title is not then add title
    If title is null and story_title is not null then add story_title
    If both are null, ignore the article.


    List<String> getTitlesByAuthor(String author) {

    }

*/

public class AuthorArticles {
  public static void main(String[] args) {

    List<String> output = AuthorArticles.getTitlesByAuthor("epaga");

    for(String str: output) {
      System.out.println(str);
    }
  }

  public static List<String> getTitlesByAuthor(String author) {
    List<String> result = new ArrayList<>();

    try{
      long page = 1;
      long total = 1;

      while(page <= total) {
        // The response could be in multiple pages. So Each page should be called separately.
        String URL_STRING = "https://jsonmock.hackerrank.com/api/articles?author=" + author + "&page=" + page;
        URL url = new URL(URL_STRING);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
          JSONParser jsonParser = new JSONParser();
          JSONObject jsonObject = (JSONObject) jsonParser.parse(inputLine);
          total = (long) jsonObject.get("total_pages");
          JSONArray data = (JSONArray) jsonObject.get("data");

          for (Object datum : data) {
            JSONObject json = (JSONObject) datum;

            if (json.get("title") != null) {
              result.add((String) json.get("title"));
            } else if (json.get("story_title") != null) {
              result.add((String) json.get("story_title"));
            }
          }
          page++;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return result;
  }
}