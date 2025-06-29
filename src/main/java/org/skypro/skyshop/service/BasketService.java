package org.skypro.skyshop.service;

import org.skypro.skyshop.exception.NoSuchProductException;
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

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void addProductById(UUID id) {

        storageService.getProductById(id)
                .orElseThrow(() -> new NoSuchProductException("Продукт с id " + id + " не найден"));

        productBasket.addProduct(id);
    }

    public UserBasket getUserBasket() {
        List<BasketItem> basketItems = productBasket.getProducts().entrySet().stream()
                .map(entry -> {
                    UUID productId = entry.getKey();
                    int count = entry.getValue();

                    return new BasketItem(
                            storageService.getProductById(productId)
                                    .orElseThrow(() -> new NoSuchProductException("Продукт с id " + productId + " не найден в хранилище при сборке корзины")),
                            count
                    );
                })
                .collect(Collectors.toList());

        return new UserBasket(basketItems);
    }
}