package com.filantrop.market.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("CARTS")
public class Cart {
    @Id
    private String cartId;
    private String category;
    private Instant createDateTime = Instant.now();
    private Instant updateDateTime;

    /*
    idColumn – поле, по которому осуществляется связь
    keyColumn – поле, по которому упорядочиваются записи в дочерней таблице.
    */
    @MappedCollection(idColumn = "CART_ID", keyColumn = "CART_KEY")
    private List<Item> items = new ArrayList<>();

    public Cart(String category) {
        this.category = category;
    }
}
