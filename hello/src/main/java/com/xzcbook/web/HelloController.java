package com.xzcbook.web;


import java.util.Random;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

  private final Logger logger = Logger.getLogger(HelloController.class);

  @Autowired
  private DiscoveryClient client;

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String index() throws Exception
  {
    ServiceInstance instance = client.getLocalServiceInstance();

    //让线程等待几秒钟
    int sleepTime = new Random().nextInt(4000);
    logger.info("sleepTime:" + sleepTime);
    Thread.sleep(sleepTime);
    logger.info("/hello, host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
    return "Hello World";
  }
}
