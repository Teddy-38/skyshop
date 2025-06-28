package org.skypro.skyshop.model.product;


import java.util.UUID;

public class Electronics extends Product {
    private int warrantyPeriodMonths;

    public Electronics(UUID id, String productName, int productPrice, boolean special, int warrantyPeriodMonths) {
        super(id, productName, productPrice, special);
        this.warrantyPeriodMonths = warrantyPeriodMonths;
    }

    public int getWarrantyPeriodMonths() {
        return warrantyPeriodMonths;
    }
}
