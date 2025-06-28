package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BasketService {

    private final ProductBasket productBasket;
    private final StorageService storageService;

    // Внедряем зависимости через конструктор (Constructor Injection)
    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    /**
     * Добавляет продукт в корзину по ID.
     * @param id ID продукта для добавления.
     * @throws IllegalArgumentException если продукт с таким ID не найден.
     */
    public void addProductById(UUID id) {
        storageService.getProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Продукт с id " + id + " не найден"));

        productBasket.addProduct(id);
    }

    /**
     * Формирует и возвращает объект корзины для отображения пользователю.
     * @return UserBasket с детальной информацией о товарах и общей стоимостью.
     */
    public UserBasket getUserBasket() {
        List<BasketItem> basketItems = productBasket.getProducts().entrySet().stream()
                .map(entry -> {
                    UUID productId = entry.getKey();
                    int count = entry.getValue();
                    return new BasketItem(storageService.getProductById(productId).get(), count);
                })
                .collect(Collectors.toList());

        return new UserBasket(basketItems);
    }
}