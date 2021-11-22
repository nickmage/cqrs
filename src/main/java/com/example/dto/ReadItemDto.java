package com.example.dto;

import com.example.entity.ReadItem;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ReadItemDto {
    private Long id;
    private String productCode;
    private String name;
    private BigDecimal price;
    private boolean isAvailable;

    public ReadItemDto(ReadItem readItem) {
        this.id = readItem.getId();
        this.productCode = readItem.getProductCode();
        this.name = readItem.getName();
        this.price = readItem.getPrice();
        this.isAvailable = readItem.isAvailable();
    }
}
