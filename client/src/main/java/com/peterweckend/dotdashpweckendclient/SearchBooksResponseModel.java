package com.peterweckend.dotdashpweckendclient;

import java.util.ArrayList;

public class SearchBooksResponseModel {
    private ArrayList<BookModel> books;

    public SearchBooksResponseModel(ArrayList<BookModel> books) {
        this.books = books;
    }

    public ArrayList<BookModel> getBooks() {
        return this.books;
    }

    public void setBooks(ArrayList<BookModel> books) {
        this.books = books;
    }
}
