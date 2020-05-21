package com.example.resttemplate.util;

import com.example.resttemplate.service.CommitsService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
