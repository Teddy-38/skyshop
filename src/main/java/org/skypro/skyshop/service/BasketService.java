package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class BasketService {

    private final StorageService storageService;
    private final List<UserBasket.Item> items = new CopyOnWriteArrayList<>();

    public BasketService(StorageService storageService) {
        this.storageService = storageService;
    }

    public void addProduct(UUID id, int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Количество должно быть положительным");
        }
        Product product = storageService.getProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Товар не найден"));

        items.add(new UserBasket.Item(product, count));
    }

    public UserBasket getBasket() {
        return new UserBasket(items);
    }

    /**
     * Очищает корзину, удаляя все товары.
     * Этот метод возвращает void.
     */
    public void clear() {
        items.clear();
    }
}