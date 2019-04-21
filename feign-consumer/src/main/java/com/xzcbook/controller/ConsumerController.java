package com.xzcbook.controller;

import com.xzcbook.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shan
 * @date 2019/4/4
 */
@RestController
public class ConsumerController
{

  @Autowired
  HelloService helloService;

  @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
  public String helloConsumer()
  {
    return helloService.hello();

  }
}
