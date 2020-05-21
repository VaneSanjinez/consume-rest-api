package com.example.resttemplate.controller;

import com.example.resttemplate.util.CommitsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (value="/commits")
public class CommitsController {
    @Autowired
    CommitsUtil commitsUtil;

    @RequestMapping(value="/{projectId}", method = RequestMethod.GET)
    ResponseEntity <Object[]> getProjectCommits (@PathVariable("projectId") int projectId, @RequestParam String privateToken){
        ResponseEntity<Object[]> commitsByProjectId;
        commitsByProjectId = commitsUtil.getCommitsByProjectId(projectId,privateToken);
        return commitsByProjectId;

    }
}
