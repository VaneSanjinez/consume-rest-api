package com.example.resttemplate.util;

import com.example.resttemplate.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ProjectUtil {

    @Autowired
    ProjectService projectService;


    public ResponseEntity<Object[]> getAllProjects() {
        ResponseEntity<Object[]> projectResponse= projectService.getAllProjects();
        return projectResponse;
    }
}
