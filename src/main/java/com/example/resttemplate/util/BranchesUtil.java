package com.example.resttemplate.util;

import com.example.resttemplate.service.BranchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class BranchesUtil {

    @Autowired
    BranchesService branchesService;
    public ResponseEntity<Object[]> getBranchesByProjectId(int projectId, String privateToken) {
        ResponseEntity<Object[]> branchesByProjectId =null;
        try{
            branchesByProjectId= branchesService.getBranchesByProjectId(projectId, privateToken);
            if(branchesByProjectId.getStatusCode().equals(HttpStatus.OK)){
                return branchesByProjectId;
            }
            else{
                return null;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return branchesByProjectId;
    }
}
