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
    ResponseEntity <Object[]> getProjectCommits (@PathVariable("projectId") int projectId,
                                                 String privateToken){
        ResponseEntity<Object[]> commitsByProjectId;
        commitsByProjectId = commitsUtil.getCommitsByProjectId(projectId,privateToken);
        return commitsByProjectId;

    }

    @RequestMapping(value="/{projectId}/{commitId}", method = RequestMethod.GET)
    public ResponseEntity <String> getCommitById (@PathVariable("commitId") String commitId,
                                                  @PathVariable("projectId") int projectId,
                                                  @RequestParam String privateToken){
        ResponseEntity<String> commitById;
        commitById = commitsUtil.getCommitsById(commitId, projectId,privateToken);
        return commitById;
    }

    @RequestMapping(value="/{projectId}/since", method=RequestMethod.GET)
    public ResponseEntity<Object[]> getCommitsSince(@PathVariable("projectId") String projectId,
                                                    @RequestParam String since,
                                                    @RequestParam String privateToken){
        ResponseEntity<Object[]> commitsSince;
        commitsSince = commitsUtil.getCommitsSince(projectId, since, privateToken);
        return commitsSince;
    }

    @RequestMapping(value="/{projectId}/until", method = RequestMethod.GET)
    public  ResponseEntity<Object[]> getCommitsUntil(@PathVariable("projectId") String projectId,
                                                     @RequestParam String until,
                                                     @RequestParam String privateToken){
        ResponseEntity<Object[]> commitsUntil;
        commitsUntil = commitsUtil.getCommitsUntil(projectId, until, privateToken);
        return commitsUntil;
    }

    @RequestMapping(value="/{projectId}/dates", method = RequestMethod.GET)
    public ResponseEntity<Object[]> getCommitsSinceUntil(@PathVariable("projectId") String projectId,
                                                         @RequestParam String since,
                                                         @RequestParam String until,
                                                         @RequestParam String privateToken){
        ResponseEntity<Object[]> commitsSinceUntil;
        commitsSinceUntil = commitsUtil.getcommitsSinceUntil(projectId, since, until, privateToken);
        return commitsSinceUntil;
    }
}
