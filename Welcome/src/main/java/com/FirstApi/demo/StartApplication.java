package com.FirstApi.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;


@RestController 
public class StartApplication {

    @Autowired 
    private  Environment env;
    @GetMapping("/welcome")
    public String getMessage() {

      String port=env.getProperty("local.server.port");
       return  "welcome Nidhi Patel" + port;
    }
}
