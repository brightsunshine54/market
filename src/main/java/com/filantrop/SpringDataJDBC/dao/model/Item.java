package com.filantrop.SpringDataJDBC.dao.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.List;

@Data
public class Item {
    @Id
    private String itemId;
    private String name;

    private Instant createDateTime = Instant.now();
    private Instant updateDateTime;

    //List<Characteristic> itemCharacteristics;
}
