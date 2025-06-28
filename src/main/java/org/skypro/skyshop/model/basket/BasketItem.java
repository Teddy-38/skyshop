package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;

/**
 * Немодифицируемый класс, представляющий один товар и его количество в корзине.
 * @param product Объект продукта.
 * @param count Количество этого продукта.
 */
public record BasketItem(Product product, int count) {
}
