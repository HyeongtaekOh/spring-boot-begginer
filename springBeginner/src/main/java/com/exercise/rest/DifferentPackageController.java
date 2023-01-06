package com.exercise.rest;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/different")
public class DifferentPackageController {

  @GetMapping
  public String sayHi() {
    return "Hi, Here is another path of controllers!";
  }

  @GetMapping("/{echoMessage}")
  public String echo(@PathVariable String echoMessage) {
    return "echo: " + echoMessage;
  }

  @GetMapping("/body")
  public Integer squareInt(@NumberFormat(style = NumberFormat.Style.NUMBER)
                            @RequestParam(name="number", required = true) Integer number) {
    return number * number;
  }
}
