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

    public Object[] getProjectsByUserNameJSONList (String usernameId, String privateToken){
        Object[] response = null;
        response = gitService.getProjectsByUserNameJSONList(usernameId,privateToken);
//        System.out.println(response.getStatusCode());
        System.out.println("From git util!");
        System.out.println(response.length);
        return response;
    }

    public ResponseEntity<Object[]> getProjectsByUserNameResponseEntity (String usernameId, String privateToken){
        ResponseEntity<Object[]> response = null;
        response = gitService.getProjectsByUserNameResponseEntity(usernameId,privateToken);
//        System.out.println(response.getStatusCode());
        System.out.println("From git util getProjectsByUserId2!");
        System.out.println(response.getBody());
        return response;
    }
}
