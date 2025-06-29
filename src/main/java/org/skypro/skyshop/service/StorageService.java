package org.skypro.skyshop.service;

import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

    @Service
    public class StorageService {

        /**
         * Возвращает продукт по его ID, обернутый в Optional.
         * @param id Уникальный идентификатор продукта.
         * @return Optional<Product>
         */
        public Optional<Product> getProductById(UUID id) {
            ClassValue<Throwable> availableProducts;
            return Optional.empty();
        }
    }