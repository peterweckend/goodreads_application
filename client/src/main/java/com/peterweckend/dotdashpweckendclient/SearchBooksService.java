package com.peterweckend.dotdashpweckendclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SearchBooksService {
    private final RestTemplate restTemplate;
    @Value("${server.default.hostname}")
    private String url;

    public SearchBooksService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public SearchBooksResponseModel searchBooks(SearchBooksRequestModel searchBooksRequestModel) {
        return this.restTemplate.getForObject("http://localhost:8080/searchBooks?searchTerms=John&field=author&pageNumber=1", SearchBooksResponseModel.class);
    }
}
