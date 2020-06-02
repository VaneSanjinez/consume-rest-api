package com.example.resttemplate.service;

import com.example.resttemplate.util.Constants;
import com.example.resttemplate.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

@Service
public class ProjectService {

    @Autowired
    Util generalUtil;

    String baseUrl = Constants.BASE_GITLAB_URL;

    public ResponseEntity<Object[]> getAllProjects() {
        String url = baseUrl +"projects/";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity request = generalUtil.setHeaderToRestTemplate();

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
        //https://gitlab.com/api/v4/users/vane-sanjinez/projects?private_token=cxXdxSAm8KmZZe7RZ7i6
        String url = baseUrl + "users/" + userid + "/projects";
//        System.out.println("https://gitlab.com/api/v4/users/vane-sanjinez/projects?private_token=cxXdxSAm8KmZZe7RZ7i6");
//        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity request = generalUtil.setHeaderToRestTemplate();
        UriComponentsBuilder builder = generalUtil.setPrivateToken(url,privateToken);
        String uri= builder.build().encode().toUriString();

        ResponseEntity<Object[]> response = restTemplate.exchange(
//                url,
                uri,
                HttpMethod.GET,
                request,
                Object[].class,
                userid,
                privateToken
        );
        return response;

    }

    public ResponseEntity<String> getProjectById(int projectId, String privateToken) {
        String url = baseUrl + "/projects/" + projectId + "?private_token="+privateToken;
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity request = generalUtil.setHeaderToRestTemplate();

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                String.class,
                projectId,
                privateToken
        );
        System.out.println(response.getBody());
        return response;
    }
}
