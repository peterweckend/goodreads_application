package com.peterweckend.dotdashpweckendclient;

import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SearchBooksService {
    private static final String SEARCH_BOOKS_PATH = "/searchBooks";
    private static final int SEARCH_BOOKS_PORT = 8080;
    private static final String API_SEARCH_TERMS_PARAM = "searchTerms";
    private static final String API_FIELD_PARAM = "field";
    private static final String API_PAGE_NUMBER_PARAM = "pageNumber";
    private final RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(SearchBooksController.class);


    public SearchBooksService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BookModel[] searchBooks(SearchBooksRequestModel searchBooksRequestModel) {
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("http")
                  .setHost(searchBooksRequestModel.getHostname())
                  .setPort(SEARCH_BOOKS_PORT)
                  .setPath(SEARCH_BOOKS_PATH)
                  .addParameter(API_SEARCH_TERMS_PARAM, searchBooksRequestModel.getSearchTerms());
        if (searchBooksRequestModel.getField() != null) {
            uriBuilder.addParameter(API_FIELD_PARAM, searchBooksRequestModel.getField());
        }
        if (searchBooksRequestModel.getPageNumber() != null) {
            uriBuilder.addParameter(API_PAGE_NUMBER_PARAM, searchBooksRequestModel.getPageNumber());
        }
        return this.restTemplate.getForObject(uriBuilder.toString(), BookModel[].class);
    }
}
