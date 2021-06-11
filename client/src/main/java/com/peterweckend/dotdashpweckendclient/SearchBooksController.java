package com.peterweckend.dotdashpweckendclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.util.Arrays;

@Component
public class SearchBooksController implements CommandLineRunner {
    private static final String HOSTNAME = "127.0.0.1";
    private static final String SEARCH_PARAM = "--search";
    private static final String SEARCH_PARAM_ABBR = "-s";
    private static final String FIELD_PARAM = "--field";
    private static final String PAGE_PARAM_ABBR = "-p";
    private static final String HOST_PARAM = "--host";
    private static final String HOST_PARAM_ABBR = "-h";
    private static final String HELP_PARAM = "--help";

    private static final Logger logger = LoggerFactory.getLogger(SearchBooksController.class);
    private final SearchBooksService searchBooksService;

    @Autowired
    public SearchBooksController(SearchBooksService searchBooksService) {
        this.searchBooksService = searchBooksService;
    }

    @Override
    public void run(String...args) {
        try {
            var searchResults = searchBooksService.searchBooks(createRequestModelForArguments(args));

            if (searchResults.getError() != null && searchResults.getError().length() != 0) {
                returnHelpInfoAndQuit(searchResults.getError());
            }

            for (BookModel book : searchResults.getBooks()) {
                logger.info("---------------------");
                logger.info("Author: " + book.getAuthor());
                logger.info("Title: " + book.getTitle());
                logger.info("Image URL: " + book.getImageUrl());
            }
            System.exit(0);
        } catch (URISyntaxException e) {
            returnHelpInfoAndQuit(e.toString());
        }
    }

    public SearchBooksRequestModel createRequestModelForArguments(String...args) {
        var searchBooksRequestModel = new SearchBooksRequestModel();
        searchBooksRequestModel.setHostname(HOSTNAME);

        var stringArgs = String.join(" ", args);
        var splitArgs = stringArgs.split(",");
        for (String arg : splitArgs) {
            var equalsSplitArgs = arg.split("=");
            switch (equalsSplitArgs[0]) {
                case HELP_PARAM:
                    returnHelpInfoAndQuit(null);
                    break;
                case SEARCH_PARAM:
                case SEARCH_PARAM_ABBR:
                    searchBooksRequestModel.setSearchTerms(equalsSplitArgs[1]);
                    break;
                case FIELD_PARAM:
                    searchBooksRequestModel.setField(equalsSplitArgs[1]);
                    break;
                case PAGE_PARAM_ABBR:
                    searchBooksRequestModel.setPageNumber(equalsSplitArgs[1]);
                    break;
                case HOST_PARAM:
                case HOST_PARAM_ABBR:
                    searchBooksRequestModel.setHostname(equalsSplitArgs[1]);
                    break;
            }
        }
        return searchBooksRequestModel;
    }

    public void returnHelpInfoAndQuit(String error) {
        if (error != null && error.length() != 0) {
            logger.error(error);
        }
        logger.error("An error occurred. Instructions for command line arguments here. Please try again.");
        System.exit(0);
    }
}
