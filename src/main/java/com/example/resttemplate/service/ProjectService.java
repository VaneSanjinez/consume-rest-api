package com.example.resttemplate.service;

import com.example.resttemplate.util.Constants;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class ProjectService {

    String baseUrl = Constants.BASE_GITLAB_URL;

    public ResponseEntity<Object[]> getAllProjects() {
        String url = baseUrl +"projects/";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));


        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<Object[]> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                Object[].class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful.");
            System.out.println(response.getBody());
        } else {
            System.out.println("Request Failed");
            System.out.println(response.getStatusCode());
        }

        return response;
    }

    public ResponseEntity<Object[]> getProjectsByUserId(String userid, String privateToken) {
        String url = baseUrl + "/users/" + userid + "/projects?private_token=" + privateToken;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<Object[]> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                Object[].class,
                userid,
                privateToken
        );
        return response;

    }
}
