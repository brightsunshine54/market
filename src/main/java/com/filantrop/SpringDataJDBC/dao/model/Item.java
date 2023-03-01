package com.filantrop.SpringDataJDBC.dao.model;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class Item {
    String itemId;
    String specification;
    //Instant createDateTime;

    //List<Characteristic> itemCharacteristics;
}
