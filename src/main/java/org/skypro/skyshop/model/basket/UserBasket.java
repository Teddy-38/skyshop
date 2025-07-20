package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;

import java.util.List;

/**
 * Представляет корзину пользователя со списком товаров.
 */
public record UserBasket(List<Item> items) {

    /**
     * Внутренний record, представляющий один элемент в корзине.
     * Вероятно, у вас здесь было пусто: public record Item() {}
     *
     * Нужно исправить, чтобы он принимал товар и количество.
     */
    public record Item(Product product, int count) {
    }
}