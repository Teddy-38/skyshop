package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.service.BasketService;
import org.skypro.skyshop.service.StorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private final BasketService basketService;
    private final StorageService storageService;

    public ShopController(BasketService basketService, StorageService storageService) {
        this.basketService = basketService;
        this.storageService = storageService;
    }

    // ... другие методы

    /**
     * Эндпоинт для добавления товара в корзину.
     * Принимает id товара и его количество (count) как параметры запроса.
     * Если count не указан, по умолчанию добавляется 1 штука.
     */
    @PostMapping("/basket/add")
    public ResponseEntity<Void> addProductToBasket(@RequestParam UUID id,
                                                   @RequestParam(defaultValue = "1") int count) {
        // ИСПОЛЬЗУЕМ ПРАВИЛЬНЫЙ МЕТОД: addProduct(id, count)
        basketService.addProduct(id, count);
        return ResponseEntity.ok().build();
    }

    /**
     * Эндпоинт для получения содержимого корзины.
     */
    @GetMapping("/basket")
    public UserBasket getBasket() {
        return basketService.getBasket();
    }
}