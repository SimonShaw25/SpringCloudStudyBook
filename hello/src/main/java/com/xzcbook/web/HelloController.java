package com.xzcbook.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shan
 * @date 2019/4/2
 */
@RestController
public class HelloController
{

  @RequestMapping(value = "/hello",method = RequestMethod.GET)
  public String index()
  {
    return "Hello World";
  }
}
