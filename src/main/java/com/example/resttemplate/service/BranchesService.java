package com.example.resttemplate.service;

import com.example.resttemplate.util.Constants;
import com.example.resttemplate.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class BranchesService {

    @Autowired
    Util generalUtil;

    String baseUrl = Constants.BASE_GITLAB_URL;
    public ResponseEntity<Object[]> getBranchesByProjectId(int projectId, String privateToken) {
        //https://gitlab.com/api/v4/projects/3472737/repository/branches?-private_token=cxXdxSAm8KmZZe7RZ7i6
        String url = baseUrl + "projects/" + projectId + "/repository/branches";
//        String url = baseUrl + "projects/" + projectId + "/repository/commits";
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builer = UriComponentsBuilder.fromUriString(url);
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
