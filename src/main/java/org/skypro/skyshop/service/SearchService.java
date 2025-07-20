package org.skypro.skyshop.service;

import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    /**
     * Ищет товары, в названии которых содержится поисковый запрос.
     * Поиск нечувствителен к регистру.
     *
     * @param query поисковая строка.
     * @return список найденных товаров.
     */
    public List<Product> search(String query) {
        final String lowerCaseQuery = query.toLowerCase();
        return storageService.getProducts().stream()
                .filter(product -> product.getName().toLowerCase().contains(lowerCaseQuery))
                .collect(Collectors.toList());
    }
}