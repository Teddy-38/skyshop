package org.skypro.skyshop.model.product;

import java.math.BigDecimal;
import java.util.UUID;

public class Electronics extends Product {

    private final int warrantyMonths;
    private final boolean isWireless;


    public Electronics(UUID id, String name, BigDecimal price, int warrantyMonths, boolean isWireless) {

        super(id, name, price);

        this.warrantyMonths = warrantyMonths;
        this.isWireless = isWireless;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public boolean isWireless() {
        return isWireless;
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", warrantyMonths=" + warrantyMonths +
                ", isWireless=" + isWireless +
                '}';
    }
}