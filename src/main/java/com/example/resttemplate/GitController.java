package com.example.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GitController {

    @Autowired
    GitUtil gitUtil;

    @RequestMapping(value="/git")
    public String hello(){
        return "Hi!";
    }
    @RequestMapping(value="/get", method = RequestMethod.GET)
    public ResponseEntity<String> getGit(){
        ResponseEntity<String> response =null;
        response = gitUtil.getRequest("cxXdxSAm8KmZZe7RZ7i6",new Long(18625237));
        System.out.println(response);
        return response;
    }
}
