package com.peterweckend.dotdashpweckendrestservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;

@Service
public class SearchBooksService {
    @Value("${api.key}")
    private String apiKey;
    @Value("${api.searchBooks.url}")
    private String url;
    private static final Logger log = LoggerFactory.getLogger(SearchBooksService.class);

    public String SearchGoodReadsForBooksByTerms(String searchTerms, String field, Integer pageNumber) {
        try {
            var searchForBooksByTermsUrl = url;
            // For a real world application, I would probably make a separate layer just for sending
            // queries to GoodReads and then handle the business logic of parsing the response here
            // in the service layer instead of doing it all in this file
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document bookSearchResults = documentBuilder.parse(new URL(searchForBooksByTermsUrl).openStream());
//            bookSearchResults.getDocumentElement().normalize();
//            log.info("Test Log" + );

            return "service";
        } catch (Exception e) {
            log.info("An error occurred: " + e);
            return "An error occurred";
        }
    }
}
