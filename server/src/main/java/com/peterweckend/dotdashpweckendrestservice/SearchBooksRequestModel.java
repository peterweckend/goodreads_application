package com.peterweckend.dotdashpweckendrestservice;

public class SearchBooksRequestModel {
    private String field;
    private String searchTerms;
    private Integer pageNumber;

    // todo: replace this with a return model instead
    public SearchBooksRequestModel(String searchTerms, String field, Integer pageNumber) {
        this.searchTerms = searchTerms;
        this.field = field;
        this.pageNumber = pageNumber;
    }

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
