package org.skypro.skyshop.model.product;

import java.math.BigDecimal;
import java.util.UUID;

public class Book extends Product {

    private final int pages;
    private final boolean isHardCover;


    public Book(UUID id, String name, BigDecimal price, int pages, boolean isHardCover) {

        super(id, name, price);

        this.pages = pages;
        this.isHardCover = isHardCover;
    }

    // Геттеры для полей класса Book
    public int getPages() {
        return pages;
    }

    public boolean isHardCover() {
        return isHardCover;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", pages=" + pages +
                ", isHardCover=" + isHardCover +
                '}';
    }
}