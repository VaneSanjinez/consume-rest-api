package com.example.resttemplate.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class Util {

    public HttpEntity setHeaderToRestTemplate(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity(headers);

        return request;
    }
    public UriComponentsBuilder setPrivateToken(String url, String privateToken){
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
        builder.queryParam("privateToken", privateToken);

        return builder;
    }
}
