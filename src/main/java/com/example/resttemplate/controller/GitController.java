package com.example.resttemplate.controller;

import com.example.resttemplate.util.GitUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(path ="/api")
//@RequestMapping(path = "${v1API}/")
@Api(value = "Gitlab microservice", description = "This API has a CRUD to consume GITLAB API")
public class GitController {

    @Autowired
    GitUtil gitUtil;


    @RequestMapping(value="/hello")
    @ApiOperation(value = "Test controller", notes = "Return a greetings String " )
    public String hello(){
        return "Hi!";
    }

    @RequestMapping(value="get/project", method = RequestMethod.GET)
    public ResponseEntity<String> getGit(){
        ResponseEntity<String> response =null;
        response = gitUtil.getRequest("cxXdxSAm8KmZZe7RZ7i6", 18625237L);
        System.out.println(response);
        return response;
    }
}