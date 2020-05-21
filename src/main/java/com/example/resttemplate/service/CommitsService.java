package com.example.resttemplate.service;

import com.example.resttemplate.util.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

@Service
public class CommitsService {

    String baseUrl = Constants.BASE_GITLAB_URL;
    public ResponseEntity<Object[]> getCommitsByProjectId(int projectId, String privateToken) {
        String url = baseUrl + "projects/" + projectId + "/repository/commits?private_token=" + privateToken;
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity(headers);

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
}
