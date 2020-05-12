package com.example.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GitController {

    @Autowired
    GitUtil gitUtil;

    @RequestMapping(value="/hello")
    public String hello(){
        return "Hi!";
    }

    @RequestMapping(value="/api/get/project", method = RequestMethod.GET)
    public ResponseEntity<String> getGit(){
        ResponseEntity<String> response =null;
        response = gitUtil.getRequest("cxXdxSAm8KmZZe7RZ7i6", 18625237L);
        System.out.println(response);
        return response;
    }
}
