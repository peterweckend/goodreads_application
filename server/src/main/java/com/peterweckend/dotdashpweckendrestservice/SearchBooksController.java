package com.peterweckend.dotdashpweckendrestservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
public class SearchBooksController {
    private final SearchBooksService searchBooksService;
    private static final Logger log = LoggerFactory.getLogger(SearchBooksController.class);

    @Autowired
    public SearchBooksController(SearchBooksService searchBooksService) {
        this.searchBooksService = searchBooksService;
    }

    // receives GET requests to http://localhost:8080/searchBooks
    @GetMapping("/searchBooks")
    public ArrayList<BookModel> SearchBooksByTerms(
            @RequestParam(value = "searchTerms") String searchTerms,
            @RequestParam(value = "field", required = false) String field,
            @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber) {
        // for more complex request parameters or in a situation where input validation
        // was required, I might consider using a request object instead of having
        // individual values like this
        try {
            return searchBooksService.SearchGoodReadsForBooksByTerms(searchTerms, field, pageNumber);
        } catch (Exception e) {
            // catch any errors we run into, log them to the console and the log file
            // and simply return them to the client as a BAD_REQUEST error along
            // with any details about the error
            log.error("An error occurred: " + e);
            // In a real world application, instead of returning a generic
            // BAD_REQUEST like this I would return using an appropriate error
            // code depending on the error and add a lot more support for error handling.
            // I would also be more careful with what information about the exception
            // is returned to the client for security reasons
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.toString());
        }
    }
}
