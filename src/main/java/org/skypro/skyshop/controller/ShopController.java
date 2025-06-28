package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.service.BasketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/shop") // Общий префикс для всех методов контроллера
public class ShopController {

    private final BasketService basketService;
    // ... другие сервисы, если они есть

    public ShopController(BasketService basketService /* ...другие сервисы */) {
        this.basketService = basketService;
        // ...
    }

    // ... другие методы вашего контроллера

    /**
     * Добавляет продукт в корзину по ID, переданному в URL.
     * @param id ID продукта.
     * @return Сообщение об успешном добавлении.
     */
    @GetMapping("/basket/{id}")
    public String addProduct(@PathVariable("id") UUID id) {
        basketService.addProductById(id);
        return "Продукт успешно добавлен";
    }

    /**
     * Отображает содержимое корзины текущего пользователя.
     * @return JSON-представление корзины пользователя.
     */
    @GetMapping("/basket")
    public UserBasket getUserBasket() {
        return basketService.getUserBasket();
    }
}