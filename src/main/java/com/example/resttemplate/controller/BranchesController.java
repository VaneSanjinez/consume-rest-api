package com.example.resttemplate.controller;

import com.example.resttemplate.util.BranchesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(value="/branches")
public class BranchesController {

    @Autowired
    BranchesUtil branchesUtil;

    @RequestMapping(value="/project/{projectId}/branches", method= RequestMethod.GET)
    ResponseEntity<Object[]> getProjectBranches(@PathVariable("projectId") int projectId,
                                                        String privateToken){
        ResponseEntity<Object[]> branchesByProjectId;
         branchesByProjectId= branchesUtil.getBranchesByProjectId(projectId,privateToken);
        return branchesByProjectId;
    }


        @RequestMapping(value="/project/{projectId}/branches/{branchId}", method = RequestMethod.GET)
    ResponseEntity<String>getBranchById(@PathVariable ("projectId") String projectId,
                                          @PathVariable ("branchId") String branchId,
//                                          @RequestParam
                                                String privateToken){
        ResponseEntity<String> branchById;
        branchById = branchesUtil.getBranchById(projectId,branchId,privateToken);
        return branchById;
        }
}
