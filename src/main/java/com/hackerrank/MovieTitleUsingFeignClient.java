package com.hackerrank;

import feign.Feign;
import feign.Param;
import feign.RequestLine;
import feign.jackson.JacksonDecoder;
import java.util.List;


public class MovieTitleUsingFeignClient {

  public static void main(String[] args) {
    Movies movies = Feign.builder()
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

    private String title;
    private int year;

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public int getYear() {
      return year;
    }

    public void setYear(int year) {
      this.year = year;
    }
  }
}
