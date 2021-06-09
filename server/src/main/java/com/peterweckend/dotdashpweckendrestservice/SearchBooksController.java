package com.peterweckend.dotdashpweckendrestservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SearchBooksController {
    @Value("${testproperty}")
    private String demoString;
    private SearchBooksService searchBooksService;

    @Autowired
    public SearchBooksController(SearchBooksService searchBooksService) {
        this.searchBooksService = searchBooksService;
    }

    @GetMapping("/searchBooks")
    public SearchBooksRequestModel SearchBooks(@RequestParam(value = "name", defaultValue = "World") String name) {
        var serviceString = searchBooksService.SearchGoodreads();
        return new SearchBooksRequestModel(demoString + serviceString);
    }
}
