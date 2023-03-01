package com.filantrop.SpringDataJDBC.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

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


    public Cart(String category) {
        this.category = category;
    }

    //List<Item> items;
    //Set<Tag> tags;
    //List<Characteristic> cartCharacteristics;
}
