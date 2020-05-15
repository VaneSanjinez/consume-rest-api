package com.example.resttemplate.util;

import com.example.resttemplate.service.GitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GitUtil {

    @Autowired
    GitService gitService;

    public ResponseEntity<String> getRequest(String privateToken, Long projectId) {
        ResponseEntity<String> response = null;
        response = gitService.getProjectDetail(privateToken,projectId);
        System.out.println(response.getStatusCode());
        return response;
    }
}
