package com.danila.homework_7.core.model;

import com.danila.homework_7.core.model.value.measurements.Quantity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class OrderDetail {
    @Embedded
    private Quantity quantity;

    private String taxStatus;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}