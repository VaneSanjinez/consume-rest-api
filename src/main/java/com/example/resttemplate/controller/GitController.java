package com.example.resttemplate.controller;

import com.example.resttemplate.util.GitUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
//@RequestMapping(path ="/api")
//@RequestMapping(path = "${v1API}/")
//@Api(value = "Gitlab microservice", description = "This API has a CRUD to consume GITLAB API")
public class GitController {

    @Autowired
    GitUtil gitUtil;


    @RequestMapping(value="/hello", method = RequestMethod.GET)
//    @ApiOperation(value = "Test controller", notes = "Return a greetings String " )
    public String hello(){
        return "Hi!";
    }

//    @RequestMapping(value="get/project", method = RequestMethod.GET)
//    public ResponseEntity<String> getGit(){
//        ResponseEntity<String> response =null;
//        response = gitUtil.getRequest("cxXdxSAm8KmZZe7RZ7i6", 18625237L);
//        System.out.println(response);
//        return response;
//    }
//
//    @RequestMapping(value="get/projectsJsonObject" , method= RequestMethod.GET)
//    public Object[] getProjectsByUserId1(){
//        Object[] getResponse = null;
//        getResponse = gitUtil.getProjectsByUserNameJSONList("vane-sanjinez","cxXdxSAm8KmZZe7RZ7i6");
////        System.out.println(getResponse.getStatusCode());
//        System.out.println(getResponse.length);
//        return getResponse;
//    }
//
//    @RequestMapping(value="get/responseEntity" , method= RequestMethod.GET)
//    public ResponseEntity<Object[]> getProjectsByUserId2(){
//        ResponseEntity<Object[]>getResponse = null;
//        getResponse = gitUtil.getProjectsByUserNameResponseEntity("vane-sanjinez","cxXdxSAm8KmZZe7RZ7i6");
////        System.out.println(getResponse.getStatusCode());
//        System.out.println(getResponse.getStatusCode());
//        System.out.println(getResponse.getBody());
//        System.out.println("from git controller!");
//        return getResponse;
//    }
//
//
//    @RequestMapping(value="/object/getList/", method=RequestMethod.GET)
//    public @ResponseBody List<Object> findAllObjects() {
//        List<Object> objects = new ArrayList<Object>();
//        objects = Arrays.asList(gitUtil.getProjectsByUserNameJSONList("vane-sanjinez", "cxXdxSAm8KmZZe7RZ7i6"));
//        return objects;
//    }

}