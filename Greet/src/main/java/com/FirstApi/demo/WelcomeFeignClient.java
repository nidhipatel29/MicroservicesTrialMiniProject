package com.FirstApi.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "demo")
public interface WelcomeFeignClient {

    @GetMapping ("/welcome")
    public String getMethodName(); 
} 