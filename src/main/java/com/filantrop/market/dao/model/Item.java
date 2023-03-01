package com.filantrop.market.dao.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.time.Instant;

@Data
public class Item {
    @Id
    private String itemId;
    private String name;
    private String specification;

    private Instant createDateTime = Instant.now();
    private Instant updateDateTime;

    //List<Characteristic> itemCharacteristics;
}
