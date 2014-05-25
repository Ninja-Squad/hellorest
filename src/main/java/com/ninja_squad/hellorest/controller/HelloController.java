package com.ninja_squad.hellorest.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

  @RequestMapping(method = RequestMethod.GET, value = "/{name}")
  public String sayHello(@PathVariable("name") String name) {
      return name + "! You are a ninja! Your first REST service is consumed!";
  }

}
