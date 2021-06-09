package com.peterweckend.dotdashpweckendrestservice;

public class SearchBooksRequestModel {
    private final String content;

    public SearchBooksRequestModel(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
