package com.xzcbook.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author shan
 * @date 2019/4/4
 */
@RestController
public class HelloService
{

  @Autowired
  RestTemplate restTemplate;

  @HystrixCommand(fallbackMethod = "helloFallback")
  public String hello()
  {
    return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();

  }

  public String helloFallback()
  {
    return "error";
  }
}
