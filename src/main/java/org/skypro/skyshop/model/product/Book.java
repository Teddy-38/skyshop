package org.skypro.skyshop.model.product;

import java.util.UUID;

public class Book extends Product {
    private String author;
    private int pageCount;

    public Book(UUID id, String productName, int productPrice, boolean special, String author, int pageCount) {
        super(id, productName, productPrice, special);
        this.author = author;
        this.pageCount = pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public int getPageCount() {
        return pageCount;
    }
}
