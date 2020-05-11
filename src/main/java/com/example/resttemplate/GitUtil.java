package com.example.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class GitUtil {

    @Autowired
    GitService gitService;

    public ResponseEntity<String> getRequest(String privateToken, String projectName) {
        ResponseEntity<String> response = null;
        System.out.println("At git util class");
        response = gitService.getGitResponse(privateToken,projectName);
        return response;

    }
}
