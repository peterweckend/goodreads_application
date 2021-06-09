package com.peterweckend.dotdashpweckendrestservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SearchBooksService {
    private static final Logger log = LoggerFactory.getLogger(SearchBooksService.class);

    public String SearchGoodreads() {
        return "service";
    }
}
