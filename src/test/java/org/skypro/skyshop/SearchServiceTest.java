package org.skypro.skyshop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.product.Book;
import org.skypro.skyshop.model.product.Electronics;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SearchServiceTest {

    @Mock
    private StorageService storageService;

    @InjectMocks
    private SearchService searchService;

    @Test
    void search_whenStorageIsEmpty_shouldReturnEmptyList() {

        String query = "телефон";
        when(storageService.getProducts()).thenReturn(Collections.emptyList());

        List<Product> result = searchService.search(query);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void search_whenProductsExistButNoMatch_shouldReturnEmptyList() {

        String query = "телефон";
        Product book = new Book(UUID.randomUUID(), "Война и мир", new BigDecimal("1500.00"), 1225, true);
        when(storageService.getProducts()).thenReturn(List.of(book));

        List<Product> result = searchService.search(query);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void search_whenMatchingProductExists_shouldReturnIt() {

        String query = "телефон";
        Product book = new Book(UUID.randomUUID(), "Война и мир", new BigDecimal("1500.00"), 1225, true);
        Product phone = new Electronics(UUID.randomUUID(), "СуперСмарт Телефон", new BigDecimal("50000.00"), 12, true);
        when(storageService.getProducts()).thenReturn(List.of(book, phone));


        List<Product> result = searchService.search(query);


        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("СуперСмарт Телефон", result.get(0).getName());
        assertSame(phone, result.get(0));
    }

    @Test
    void search_shouldBeCaseInsensitive() {

        String query = "ТеЛеФоН";
        Product phone = new Electronics(UUID.randomUUID(), "СуперСмарт Телефон", new BigDecimal("50000.00"), 12, true);
        when(storageService.getProducts()).thenReturn(List.of(phone));


        List<Product> result = searchService.search(query);


        assertEquals(1, result.size());
        assertEquals("СуперСмарт Телефон", result.get(0).getName());
    }
}