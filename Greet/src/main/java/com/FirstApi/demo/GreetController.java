package com.FirstApi.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;



@RestController 
public class GreetController {

    @Autowired 
   private  WelcomeFeignClient welcomeFeignClient;

    @GetMapping("/greet")
    public String getMessage(){
       return "HI Nidhi:" + welcomeFeignClient.getMethodName(); 
    }  
    
}
