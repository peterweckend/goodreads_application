package com.peterweckend.dotdashpweckendclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
            // In a real world application I wouldn't hardcode the output like this,
            // I'd put it in its own set of files instead
            for (BookModel book : searchResults) {
                logger.info("---------------------");
                logger.info("Author: " + book.getAuthor());
                logger.info("Title: " + book.getTitle());
                logger.info("Image URL: " + book.getImageUrl());
            }
            logger.info("Fetching complete. Re-run the program to fetch with a different set of parameters.");
        } catch (Exception e) {
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
        logger.info("---------------------");
        logger.info("The client accepts the following command line arguments separated by a comma: ");
        logger.info("--help (outputs a usage message and exists)");
        logger.info("-s=TERMS, --search=TERMS (search terms for the GoodReads API)");
        logger.info("--field=FIELD (where FIELD is one of 'author' or 'title', or 'all' [default])");
        logger.info("-p=NUMBER (page number of results to fetch from GoodReads, defaults to 1)");
        logger.info("-h=HOSTNAME, --host=HOSTNAME (the hostname or ip address where the server can be found. Defaults to 127.0.0.1");
        logger.info("Example: ./mvnw spring-boot:run -Dspring-boot.run.arguments=\"--search=kitchen confidential,--field=title,--host=localhost,-p=1\"");
        if (error != null && error.length() != 0) {
            logger.info("---------------------");
            logger.error("An error occurred: " + error);
            logger.error("Please try again.");
        }
        System.exit(0);
    }
}
