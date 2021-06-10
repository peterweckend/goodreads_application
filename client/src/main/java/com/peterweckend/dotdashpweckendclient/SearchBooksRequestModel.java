package com.peterweckend.dotdashpweckendclient;

public class SearchBooksRequestModel {
    private String searchTerms;
    private String field;
    private Integer pageNumber;

    public SearchBooksRequestModel(String searchTerms, String field, Integer pageNumber) {
        this.searchTerms = searchTerms;
        this.field = field;
        this.pageNumber = pageNumber;
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

    public Integer getPageNumber() {
        return this.pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
}
