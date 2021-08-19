package com.hackerrank;

import feign.Feign;
import feign.json.JsonDecoder;


public class MovieTitleUsingFeignClient {

  public static void main(String[] args) {
    Movies movies = Feign.builder()
        .decoder(new JsonDecoder())
        .target(Movies.class, "https://jsonmock.hackerrank.com/api/movies");

    Title titles = movies.title("spiderman", 1);

    for(MovieData data: titles.data) {
      System.out.println("Movie Title :"+data.title+", year:"+ data.year);
    }
  }
}
