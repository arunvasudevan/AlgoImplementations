package com.hackerrank;

import feign.Param;
import feign.RequestLine;


public interface Movies {

  @RequestLine("GET /search/?Title={title}&page={page}")
  Title title(@Param("title") String title, @Param("page") int page);
}
