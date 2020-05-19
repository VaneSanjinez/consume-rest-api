package com.example.resttemplate.controller;


import com.example.resttemplate.util.ProjectUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value="/projects")
@Api(value = "GitLab Projects Controller", description = "This controller takes care of projects endpoint from GitLab")
public class ProjectController {

    @Autowired
    ProjectUtil projectUtil;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object[]> getAllProjects(){
        ResponseEntity<Object[]> response =null;
        response = projectUtil.getAllProjects();
        System.out.println(response);
        return response;
    }
}
