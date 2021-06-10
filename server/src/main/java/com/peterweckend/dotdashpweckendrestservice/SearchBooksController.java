package com.peterweckend.dotdashpweckendrestservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SearchBooksController {
    private final SearchBooksService searchBooksService;

    @Autowired
    public SearchBooksController(SearchBooksService searchBooksService) {
        this.searchBooksService = searchBooksService;
    }

    @GetMapping("/searchBooks")
    public SearchBooksResponseModel SearchBooksByTerms(
            @RequestParam(value = "searchTerms") String searchTerms,
            @RequestParam(value = "field", defaultValue = SearchBooksService.AUTHOR_FIELD) String field,
            @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber) {
        return searchBooksService.SearchGoodReadsForBooksByTerms(searchTerms, field, pageNumber);
    }
}
