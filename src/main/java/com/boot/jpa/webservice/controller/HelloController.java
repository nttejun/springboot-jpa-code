package com.boot.jpa.webservice.controller;

import com.boot.jpa.webservice.WebserviceApplication;
import com.boot.jpa.webservice.service.MemberService;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/hello")
    public String test(){
        return "hello~~";
    }

    @RequestMapping("/crud")
    public String crud(){
        memberService.crudExample();
        return "example1";
    }

}
