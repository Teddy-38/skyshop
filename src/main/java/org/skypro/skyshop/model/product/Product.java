package org.skypro.skyshop.model.product;

import org.skypro.skyshop.model.search.Searchable;
import java.util.UUID;
import java.util.Objects;

public class Product implements Searchable {
    private final UUID id;
    private String productName;
    private int productPrice;
    private boolean special;

    public Product(UUID id, String productName, int productPrice, boolean special) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.special = special;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public boolean isSpecial() {
        return special;
    }

    @Override
    public String getSearchTerm() {
        return this.productName;
    }

    @Override
    public String getContentType() {
        return "product";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
