package com.example.resttemplate;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class GitService {


//    public ResponseEntity<String> getGitResponse(String privateToken, String projectName) {
    public ResponseEntity<String> getGitResponse(String privateToken, String projectName) {
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity request = new HttpEntity(headers);
//        String url = "http://gitlab.com/api/v4/projects?private_token="+privateToken+"&search="+projectName;
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
//        System.out.println(response);
//        return response;
        // request url

//        String url = "http://gitlab.com/api/v4/projects?private_token="+privateToken+"&search="+projectName;
        String url = "https://gitlab.com/api/v4/projects/18625237?private_token=XiL9rQmkMjmz8z9AQijY";
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
                String.class,1
        );
//        String url = "https://jsonplaceholder.typicode.com/posts/{id}";
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        headers.set("X-Request-Source", "Desktop");
//        HttpEntity request = new HttpEntity(headers);
//        ResponseEntity<String> response = restTemplate.exchange(
//                url,
//                HttpMethod.GET,
//                request,
//                String.class,
//                3
//        );

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
