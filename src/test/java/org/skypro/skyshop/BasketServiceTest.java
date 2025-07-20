package org.skypro.skyshop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.product.Book;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.service.BasketService;
import org.skypro.skyshop.service.StorageService;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BasketServiceTest {

    @Mock
    private StorageService storageService;

    @InjectMocks
    private BasketService basketService;

    @Test
    void addProductToBasket_whenProductExists_shouldAddSuccessfully() {

        UUID productId = UUID.randomUUID();
        Product book = new Book(productId, "Тестовая книга", new BigDecimal("100.00"), 250, true);
        when(storageService.getProductById(productId)).thenReturn(Optional.of(book));

        basketService.addProduct(productId, 2);

        var basket = basketService.getBasket();
        assertNotNull(basket);
        assertEquals(1, basket.items().size());
        verify(storageService, times(1)).getProductById(productId);
    }
}