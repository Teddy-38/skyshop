package org.skypro.skyshop.model.basket;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@SessionScope // Эта аннотация указывает, что для каждой HTTP-сессии будет создан свой экземпляр этого бина.
public class ProductBasket {

    private final Map<UUID, Integer> products = new HashMap<>();

    /**
     * Добавляет продукт в корзину или увеличивает его количество, если он уже там.
     * @param id Уникальный идентификатор продукта.
     */
    public void addProduct(UUID id) {
        // Метод merge идеально подходит: если ключ уже существует, он применяет функцию,
        // а если нет - добавляет новую пару (ключ, значение).
        products.merge(id, 1, Integer::sum);
    }

    /**
     * Возвращает неизменяемую карту продуктов в корзине.
     * @return Неизменяемая Map<UUID, Integer> с продуктами и их количеством.
     */
    public Map<UUID, Integer> getProducts() {
        // Оборачиваем мапу в Collections.unmodifiableMap, чтобы предотвратить
        // ее изменение извне этого класса.
        return Collections.unmodifiableMap(products);
    }
}