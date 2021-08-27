package com.hackerrank;

import feign.Feign;
import feign.Param;
import feign.RequestLine;
import feign.jackson.JacksonDecoder;
import feign.okhttp.OkHttpClient;
import java.util.List;


public class MovieTitleUsingFeignClient {

  public static void main(String[] args) {
    Movies movies = Feign.builder()
        .client(new OkHttpClient())
        .decoder(new JacksonDecoder())
        .target(Movies.class, "https://jsonmock.hackerrank.com/api/movies");

    Title titles = movies.title("spiderman", 1);

    for(MovieData movieData: titles.getData()) {
      System.out.println("Movie Title :"+movieData.getTitle()+", year:"+ movieData.getYear());
    }
  }


  interface Movies {

    @RequestLine("GET /search/?Title={title}&page={page}")
    Title title(@Param("title") String title, @Param("page") int page);
  }

  static class Title {

    private List<MovieData> data;

    public List<MovieData> getData() {
      return data;
    }

    public void setData(List<MovieData> data) {
      this.data = data;
    }
  }

  static class MovieData {

    private String Title;
    private int Year;

    public String getTitle() {
      return Title;
    }

    public void setTitle(String title) {
      this.Title = title;
    }

    public int getYear() {
      return Year;
    }

    public void setYear(int year) {
      this.Year = year;
    }
  }
}
