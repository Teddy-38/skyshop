package org.skypro.skyshop.service;

import jakarta.annotation.PostConstruct;
import org.skypro.skyshop.model.product.Book;
import org.skypro.skyshop.model.product.Electronics;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class StorageService {

    private final List<Product> products = new CopyOnWriteArrayList<>();

    @PostConstruct
    public void init() {
        products.add(new Electronics(UUID.randomUUID(), "Смартфон 'Галактика'", new BigDecimal("59990.00"), 12, true));
        products.add(new Electronics(UUID.randomUUID(), "Ноутбук 'Профессионал'", new BigDecimal("120000.00"), 24, true));
        products.add(new Book(UUID.randomUUID(), "Искусство программирования", new BigDecimal("2500.50"), 1138, true));
    }

    public List<Product> getProducts() {
        return products;
    }

    public Optional<Product> getProductById(UUID id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
}