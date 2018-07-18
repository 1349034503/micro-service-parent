package com.alern.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @HystrixCommand(fallbackMethod = "hiError")     //开启熔断器，指定熔断方法
    public String hiService(String name) {
//        this.loadBalancerClient.choose("service-B");//随机访问策略
        return restTemplate.getForObject("http://SERVICE-A/hi?name="+name,String.class);
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

}
