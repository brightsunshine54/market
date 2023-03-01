package com.filantrop.market.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {
    @Id
    private String cartId;
    private String category;
    private Instant createDateTime = Instant.now();
    private Instant updateDateTime;

    @MappedCollection(idColumn = "CART_ID")
    private Set<Item> items = new HashSet<>();

    public Cart(String category) {
        this.category = category;
    }
}
