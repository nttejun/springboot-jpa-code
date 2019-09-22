package com.boot.jpa.webservice.controller;

import com.boot.jpa.webservice.WebserviceApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String test(){
        return "hello~~";
    }

}
