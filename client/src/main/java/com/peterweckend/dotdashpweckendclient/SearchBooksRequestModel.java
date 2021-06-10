package com.peterweckend.dotdashpweckendclient;

public class SearchBooksRequestModel {
    private String searchTerms;
    private String sort;
    private Integer pageNumber;

    public SearchBooksRequestModel(String searchTerms, String sort, Integer pageNumber) {
        this.searchTerms = searchTerms;
        this.sort = sort;
        this.pageNumber = pageNumber;
    }

    public SearchBooksRequestModel() {}

    public String getSearchTerms() {
        return this.searchTerms;
    }

    public void setSearchTerms(String searchTerms) {
        this.searchTerms = searchTerms;
    }

    public String getSort() {
        return this.sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getPageNumber() {
        return this.pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
}
