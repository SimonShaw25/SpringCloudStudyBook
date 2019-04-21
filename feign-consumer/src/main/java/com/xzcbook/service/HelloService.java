package com.xzcbook.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shan
 * @date 2019/4/4
 */
@FeignClient("hello-service")
public interface HelloService
{
    @RequestMapping("/hello")
    String hello();
}
