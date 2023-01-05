package com.exercise.springBeginner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstGETController {

  @GetMapping("/test")
  public String getTestString() {
    return "Successful first attempt to response to GET-REST-API!";
  }
}
