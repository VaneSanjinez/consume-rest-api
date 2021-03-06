package com.example.resttemplate.util;

import com.example.resttemplate.service.CommitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CommitsUtil {
    @Autowired
    CommitsService commitsService;

    public ResponseEntity<Object[]> getCommitsByProjectId(int projectId, String privateToken) {
        ResponseEntity<Object[]> commitsByProjectId = null;
       // try{
            commitsByProjectId = commitsService.getCommitsByProjectId(projectId, privateToken);
//            if(commitsByProjectId.getStatusCode().equals(HttpStatus.OK)){
//                return commitsByProjectId;
//            }
//            else{
//                return null;
//            }
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
        return commitsByProjectId;
    }

    public ResponseEntity<String> getCommitsById(String commitId, int projectId, String privateToken) {
        ResponseEntity<String> commitById =null;
        try{
            commitById = commitsService.getCommitById(commitId, projectId, privateToken);
            if(commitById.getStatusCode().equals(HttpStatus.OK)){
                return commitById;
            }
            else{
                return null;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
                return commitById;
    }

    public ResponseEntity<Object[]> getCommitsSince(String projectId, String since, String privateToken) {
        ResponseEntity<Object[]> commitsSince;
        commitsSince = commitsService.getCommitsSince(projectId, since, privateToken);
        return commitsSince;
    }

    public ResponseEntity<Object[]> getCommitsUntil(String projectId, String until, String privateToken) {
        ResponseEntity<Object[]> commitsUntil = null;
        try{
            commitsUntil = commitsService.getCommitsUntil(projectId,until,privateToken);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return commitsUntil;
    }

    public ResponseEntity<Object[]> getcommitsSinceUntil(String projectId, String since, String until, String privateToken) {
        ResponseEntity<Object[]> commitsSinceUntil = null;
        try{
            commitsSinceUntil = commitsService.getCommitsSinceUntil(projectId,since,until,privateToken);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return commitsSinceUntil;
    }
}
