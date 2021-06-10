package com.peterweckend.dotdashpweckendrestservice;

import java.util.ArrayList;

public class SearchBooksResponseModel {
    private String error;
    private ArrayList<BookModel> books;

    public SearchBooksResponseModel(String error, ArrayList<BookModel> books) {
        this.error = error;
        this.books = books;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ArrayList<BookModel> getBooks() {
        return this.books;
    }

    public void setBooks(ArrayList<BookModel> books) {
        this.books = books;
    }
}
