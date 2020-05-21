package com.example.resttemplate.controller;


import com.example.resttemplate.util.ProjectUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (value="/projects")
@Api(value = "GitLab Projects Controller", description = "This controller takes care of projects endpoint from GitLab")
public class ProjectController {

    @Autowired
    ProjectUtil projectUtil;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object[]> getAllProjects(){
        ResponseEntity<Object[]> response;
        response = projectUtil.getAllProjects();
        System.out.println(response);
        return response;
    }
    //Should this be here? or not
    @RequestMapping(value="/users/{userId}", method= RequestMethod.GET)
    public ResponseEntity<Object[]> getAllProjectsByUserId(@PathVariable("userId") String userid, @RequestParam String privateToken){
        ResponseEntity<Object[]> response;
        response = projectUtil.getProjectsByUserId(userid, privateToken);
        System.out.println(response);
        return response;
    }

    @RequestMapping(value = "/{projectId}", method=RequestMethod.GET)
    public ResponseEntity<String> getProjectById (@PathVariable("projectId") int projectId, @RequestParam String privateToken){
        ResponseEntity<String> response;
        response = projectUtil.getProjectById(projectId, privateToken);
        return response;
    }
}
