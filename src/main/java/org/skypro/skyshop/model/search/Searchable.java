package org.skypro.skyshop.model.search;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;

public interface Searchable {
    UUID getId();

    // Вспомогательные методы для поиска и сериализации, которые не должны попадать в JSON
    @JsonIgnore
    String getSearchTerm();

    @JsonIgnore
    String getContentType();
}