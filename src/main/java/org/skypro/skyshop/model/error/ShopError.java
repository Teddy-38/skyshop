package org.skypro.skyshop.model.error;

/**
 * Модель для представления ошибки в формате JSON.
 *
 * @param code    Машиночитаемый код ошибки.
 * @param message Понятное человеку сообщение об ошибке.
 */
public record ShopError(String code, String message) {
}