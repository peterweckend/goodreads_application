package com.peterweckend.dotdashpweckendclient;

public class BookModel {
    private String author;
    private String title;
    private String imageUrl;

    public BookModel(String author, String title, String imageUrl) {
        this.author = author;
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
