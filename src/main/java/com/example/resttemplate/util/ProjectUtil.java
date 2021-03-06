package com.example.resttemplate.util;

import com.example.resttemplate.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ProjectUtil {

    @Autowired
    ProjectService projectService;


    public ResponseEntity<Object[]> getAllProjects(String privateToken) {
        ResponseEntity<Object[]> projectResponse= projectService.getAllProjects(privateToken);
        return projectResponse;
    }

    public ResponseEntity<Object[]> getProjectsByUserId(String userid, String privateToken) {
        ResponseEntity<Object[]> projectsByUserId = null;
        try{
            projectsByUserId = projectService.getProjectsByUserId(userid, privateToken);
            if(projectsByUserId.getStatusCode().equals(HttpStatus.OK)){
                return projectsByUserId;
            }
            else{
                return null;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return projectsByUserId;
    }

    public ResponseEntity<Object> getProjectById(String projectId, String privateToken) {
        ResponseEntity<Object> projectById;
        projectById = projectService.getProjectById(projectId, privateToken);
        return projectById;
    }
}
