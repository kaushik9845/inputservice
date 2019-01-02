package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Result;

@RestController
public class InputController {

    @Autowired
    RestTemplate restTemplate;
    
    @Autowired
    Environment env;
    

    @CrossOrigin(origins="http://localhost:4200")
    @RequestMapping(method=RequestMethod.POST,name="inputservice")
    public Iterable inputservice(@RequestBody Result result) {
   
    	return  restTemplate.postForEntity(env.getProperty("jpa.url"),result,Iterable.class).getBody();
    		}
}