package com.peterweckend.dotdashpweckendclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SearchBooksController implements ApplicationRunner {
    private ApplicationArguments applicationArguments;
    private static final Logger logger = LoggerFactory.getLogger(SearchBooksController.class);
    private SearchBooksService searchBooksService;

    @Autowired
    public SearchBooksController(SearchBooksService searchBooksService) {
        this.searchBooksService = searchBooksService;
    }

    @Override
    public void run(ApplicationArguments arg0) throws Exception {
        // use CommandLineRunner if the command args are space separated
        var searchResults = searchBooksService.searchBooks(null);
        if (searchResults.getError() != null && searchResults.getError().length() != 0) {
            logger.error("An error occurred. Instructions for command line arguments here. Please try again.");
            logger.error(searchResults.getError());
        } else {
            for (BookModel book : searchResults.getBooks()) {
                logger.info("---------------------");
                logger.info("Author: " + book.getAuthor());
                logger.info("Title: " + book.getTitle());
                logger.info("Image URL: " + book.getImageUrl());
            }
        }
        logger.info(arg0.getNonOptionArgs().toString());
        System.exit(0);
    }
}
