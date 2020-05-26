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

    public ResponseEntity<Object[]> getCommitsSince(String projectId, String since, String privateToken) {
//        String url = baseUrl + "projects/" + projectId + "/repository/commits?since=" + since.toString() + "&privateToken=" + privateToken;
        String url = baseUrl + "projects/" + projectId +"/repository/commits";
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
        builder.queryParam("since", since);
        builder.queryParam("privateToken", privateToken);

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
        UriComponentsBuilder builer = UriComponentsBuilder.fromUriString(url);
        builer.queryParam("until", until);
        builer.queryParam("privateToken", privateToken);

        String uri = builer.build().encode().toUriString();
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
