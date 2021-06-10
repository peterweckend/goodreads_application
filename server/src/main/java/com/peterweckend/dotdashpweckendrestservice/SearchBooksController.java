package com.peterweckend.dotdashpweckendrestservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchBooksController {

    private SearchBooksService searchBooksService;

    @Autowired
    public SearchBooksController(SearchBooksService searchBooksService) {
        this.searchBooksService = searchBooksService;
    }

    @GetMapping("/searchBooks")
    public String SearchBooksByTerms(
            @RequestParam(value = "searchTerms") String searchTerms,
            @RequestParam(value = "field", defaultValue = "title") String field,
            @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber) {
        var serviceString = searchBooksService.SearchGoodReadsForBooksByTerms(searchTerms, field, pageNumber);
        return serviceString;
    }
}
