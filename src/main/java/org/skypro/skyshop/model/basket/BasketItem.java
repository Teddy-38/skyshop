package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;

/**
 * Представляет один элемент в корзине: товар и его количество.
 */
public record BasketItem(Product product, int count) {
}