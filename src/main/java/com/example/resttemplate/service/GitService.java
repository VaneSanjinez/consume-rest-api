package com.example.resttemplate.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import com.example.resttemplate.util.Constants;

@Service
public class GitService {

    String baseUrl = Constants.BASE_GITLAB_URL;
    public ResponseEntity<String> getProjectDetail(String privateToken, Long projectId) {
//        String url = "https://gitlab.com/api/v4/projects/18625237?private_token=XiL9rQmkMjmz8z9AQijY";
        String url = baseUrl +"projects/{project-id}?private_token={privateToken}";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("X-Request-Source", "Desktop");

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                String.class,projectId,privateToken
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

    //Returns a list of JSON objects
    public Object[] getProjectsByUserNameJSONList(String userNameId, String privateToken){
//        https://gitlab.com/api/v4/users/vane-sanjinez/projects?private_token=cxXdxSAm8KmZZe7RZ7i6
//        String url = "https://gitlab.com/api/v4/users/vane-sanjinez/projects?private_token=cxXdxSAm8KmZZe7RZ7i6";
        String url = baseUrl +"/users/{userNameId}/projects?private_token={privateToken}";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("X-Request-Source", "Desktop");

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<Object[]> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                Object[].class
                ,
                userNameId,
                privateToken
        );

        Object[] objects = response.getBody();


        MediaType contentType = response.getHeaders().getContentType();
        HttpStatus statusCode = response.getStatusCode();

        response.getStatusCode();

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful.");
            System.out.println(response.getBody());
        } else {
            System.out.println("Request Failed");
            System.out.println(response.getStatusCode());
        }
        return objects;
    }

    //Returns ResponseEntity Object
    public ResponseEntity<Object[]> getProjectsByUserNameResponseEntity(String userNameId, String privateToken) {
//        https://gitlab.com/api/v4/users/vane-sanjinez/projects?private_token=cxXdxSAm8KmZZe7RZ7i6
//        String url = "https://gitlab.com/api/v4/users/vane-sanjinez/projects?private_token=cxXdxSAm8KmZZe7RZ7i6";
        String url = baseUrl + "/users/{userNameId}/projects?private_token={privateToken}";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("X-Request-Source", "Desktop");

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<Object[]> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                Object[].class
                ,
                userNameId,
                privateToken
        );

        response.getStatusCode();

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful.");
            System.out.println(response.getBody());
        } else {
            System.out.println("Request Failed");
            System.out.println(response.getStatusCode());
        }
        return response;
    }
}
