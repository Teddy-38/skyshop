package org.skypro.skyshop.model.basket;

import java.math.BigDecimal;
import java.util.List;

public class UserBasket {

    private final List<BasketItem> items;
    private final BigDecimal total;

    public UserBasket(List<BasketItem> items) {
        this.items = items;

        this.total = items.stream()

                .map(item -> item.product().getPrice().multiply(BigDecimal.valueOf(item.count())))

                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public BigDecimal getTotal() {
        return total;
    }
}