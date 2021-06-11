package com.peterweckend.dotdashpweckendclient;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SearchBooksService {
    // I would likely move these values into their own properties file
    // instead of keeping them here in a real world application
    private static final String SEARCH_BOOKS_PATH = "/searchBooks";
    private static final int SEARCH_BOOKS_PORT = 8080; // server uses port 8080
    private static final String API_SEARCH_TERMS_PARAM = "searchTerms";
    private static final String API_FIELD_PARAM = "field";
    private static final String API_PAGE_NUMBER_PARAM = "pageNumber";
    private final RestTemplate restTemplate;

    public SearchBooksService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    // In a real world application, I would likely have a layer separate from the
    // service layer to handle the sending of the request to distinguish between
    // any business rules I might have and the request functionality
    public BookModel[] searchBooks(SearchBooksRequestModel searchBooksRequestModel) {
        // set up the URL to contact the server's API endpoint
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("http")
                  .setHost(searchBooksRequestModel.getHostname())
                  .setPort(SEARCH_BOOKS_PORT)
                  .setPath(SEARCH_BOOKS_PATH)
                  .addParameter(API_SEARCH_TERMS_PARAM, searchBooksRequestModel.getSearchTerms());
        // add any optional params to the request
        if (searchBooksRequestModel.getField() != null) {
            uriBuilder.addParameter(API_FIELD_PARAM, searchBooksRequestModel.getField());
        }
        if (searchBooksRequestModel.getPageNumber() != null) {
            uriBuilder.addParameter(API_PAGE_NUMBER_PARAM, searchBooksRequestModel.getPageNumber());
        }
        // perform the request
        return this.restTemplate.getForObject(uriBuilder.toString(), BookModel[].class);
    }
}
