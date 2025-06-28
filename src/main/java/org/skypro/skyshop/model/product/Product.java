package org.skypro.skyshop.model.product;

import java.math.BigDecimal;
import java.util.UUID;


public class Product {

    private final UUID id;
    private final String name;
    private final BigDecimal price;

    public Product(UUID id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return java.util.Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }
}
