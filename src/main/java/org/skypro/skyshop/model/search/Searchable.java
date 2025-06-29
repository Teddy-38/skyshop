package org.skypro.skyshop.model.search;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;

public interface Searchable {
    UUID getId();

    @JsonIgnore
    String getSearchTerm();

    @JsonIgnore
    String getContentType();
}
