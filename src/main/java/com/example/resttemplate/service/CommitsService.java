package com.example.resttemplate.service;

import com.example.resttemplate.util.Constants;
import com.example.resttemplate.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CommitsService {

    @Autowired
    Util generalUtil;

    String baseUrl = Constants.BASE_GITLAB_URL;
    public ResponseEntity<Object[]> getCommitsByProjectId(int projectId, String privateToken) {
        String url = baseUrl + "projects/" + projectId + "/repository/commits";
        System.out.println(url);

        UriComponentsBuilder builder = generalUtil.setPrivateToken(url,privateToken);
        RestTemplate restTemplate = new RestTemplate();
//        HttpEntity request = generalUtil.setHeaderToRestTemplate();
//        String uri= builder.build().encode().toUriString();


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Private-Token",privateToken);
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<Object[]> response = restTemplate.exchange(
                url,
//                uri,
                HttpMethod.GET,
                request,
                Object[].class,
                projectId
        );
        return response;
    }

    public ResponseEntity<String> getCommitById(String commitId,int projectId, String privateToken) {
        String url = baseUrl + "projects/" + projectId + "/repository/commits/"+ commitId;
        System.out.println(url);
        UriComponentsBuilder builder = generalUtil.setPrivateToken(url,privateToken);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity request = generalUtil.setHeaderToRestTemplate();
        String uri= builder.build().encode().toUriString();

        ResponseEntity<String> response = restTemplate.exchange(
//                url,
                uri,
                HttpMethod.GET,
                request,
                String.class,
                projectId,
                commitId,
                privateToken
        );
        return response;
    }

    public ResponseEntity<Object[]> getCommitsSince(String projectId, String since, String privateToken) {
//        String url = baseUrl + "projects/" + projectId + "/repository/commits?since=" + since.toString() + "&privateToken=" + privateToken;
        String url = baseUrl + "projects/" + projectId +"/repository/commits";
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = generalUtil.setPrivateToken(url,privateToken);
        builder.queryParam("since", since);

        String uri= builder.build().encode().toUriString();

        System.out.println("URI: " + uri);
        HttpEntity request = generalUtil.setHeaderToRestTemplate();
        ResponseEntity<Object[]> response = restTemplate.exchange(
//                url,
                uri,
                HttpMethod.GET,
                request,
                Object[].class,
                projectId
//                since,
//                privateToken
        );
        return response;

    }

    public ResponseEntity<Object[]> getCommitsUntil(String projectId, String until, String privateToken) {
//        https://gitlab.com/api/v4/projects/18625237/repository/commits?until=2019-02-19&privateToken=cxXdxSAm8KmZZe7RZ7i6
        String url = baseUrl + "projects/" + projectId + "/repository/commits";
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = generalUtil.setPrivateToken(url,privateToken);
        builder.queryParam("until", until);

        String uri = builder.build().encode().toUriString();
        System.out.println(uri);
        HttpEntity request = generalUtil.setHeaderToRestTemplate();
        ResponseEntity<Object[]> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                request,
                Object[].class,
                projectId
        );
        return response;
    }

    public ResponseEntity<Object[]> getCommitsSinceUntil(String projectId, String since, String until, String privateToken) {
//        https://gitlab.com/api/v4/projects/18625237/repository/commits?since=2019-02-15&until=2019-02-18&privateToken=cxXdxSAm8KmZZe7RZ7i6
        String url = baseUrl + "projects/" + projectId + "/repository/commits";
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = generalUtil.setPrivateToken(url,privateToken);
        builder.queryParam("since", since);
        builder.queryParam("until", until);
        String uri = builder.build().encode().toUriString();
        System.out.println(uri);
        HttpEntity request = generalUtil.setHeaderToRestTemplate();
        ResponseEntity<Object[]> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                request,
                Object[].class,
                projectId
        );
        return response;

    }
}
