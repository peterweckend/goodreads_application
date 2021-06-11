package com.peterweckend.dotdashpweckendclient;

public class SearchBooksRequestModel {
    private String searchTerms;
    private String field;
    private String pageNumber;
    private String hostname;

    public SearchBooksRequestModel(String searchTerms, String field, String pageNumber, String hostname) {
        this.searchTerms = searchTerms;
        this.field = field;
        this.pageNumber = pageNumber;
        this.hostname = hostname;
    }

    public SearchBooksRequestModel() {}

    public String getSearchTerms() {
        return this.searchTerms;
    }

    public void setSearchTerms(String searchTerms) {
        this.searchTerms = searchTerms;
    }

    public String getField() {
        return this.field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getPageNumber() {
        return this.pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getHostname() {
        return this.hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
}
