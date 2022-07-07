package com.ocp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Compare {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        Comparator<Book> c1 = (b1, b2) -> b1.getGenre().compareTo(b2.getGenre()); //1
        books.stream().sorted(c1.thenComparing(Book::getTitle)); //2
        // System.out.println(books);
    }
}

class Book {
    private String title;
    private String genre;

    public Book(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
