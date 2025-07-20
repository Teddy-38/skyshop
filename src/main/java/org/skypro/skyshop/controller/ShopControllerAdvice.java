package org.skypro.skyshop.controller;

import org.skypro.skyshop.exception.NoSuchProductException;
import org.skypro.skyshop.model.error.ShopError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ShopControllerAdvice {

    /**
     * Обработчик исключения NoSuchProductException.
     * Срабатывает, когда продукт не найден в хранилище.
     *
     * @param e перехваченное исключение.
     * @return ResponseEntity со статусом 404 (NOT_FOUND) и телом ShopError.
     */
    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ShopError> handleProductNotFound(NoSuchProductException e) {
        ShopError error = new ShopError(
                "PRODUCT_NOT_FOUND",
                "Товар с указанным ID не найден в каталоге"
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}