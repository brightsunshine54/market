package com.filantrop.SpringDataJDBC.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {
    @Id
    private String cartId;
    private String category;

    public Cart(String category){
        this.category = category;
    }

    //Instant createDateTime;

    //List<Item> items;

    //List<Characteristic> cartCharacteristics;
}
