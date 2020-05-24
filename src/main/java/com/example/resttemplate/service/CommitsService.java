package com.example.resttemplate.service;

import com.example.resttemplate.util.Constants;
import com.example.resttemplate.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

@Service
public class CommitsService {

    @Autowired
    Util generalUtil;

    String baseUrl = Constants.BASE_GITLAB_URL;
    public ResponseEntity<Object[]> getCommitsByProjectId(int projectId, String privateToken) {
        String url = baseUrl + "projects/" + projectId + "/repository/commits?private_token=" + privateToken;
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity request = generalUtil.setHeaderToRestTemplate();

        ResponseEntity<Object[]> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                Object[].class,
                projectId,
                privateToken
        );
        return response;
    }

    public ResponseEntity<String> getCommitById(String commitId,int projectId, String privateToken) {
        String url = baseUrl + "projects/" + projectId + "/repository/commits/"+ commitId +"?private_token=" + privateToken;
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity request = generalUtil.setHeaderToRestTemplate();

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                String.class,
                projectId,
                commitId,
                privateToken
        );
        return response;
    }
}
