package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReadItem {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String productCode;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(precision = 20, scale = 2)
    private BigDecimal price;

    @Column(nullable = false, columnDefinition = "boolean not null default false")
    private boolean isAvailable;

    @JsonIgnore
    @OneToOne(mappedBy = "readItem")
    private WriteItem writeItem;
}
