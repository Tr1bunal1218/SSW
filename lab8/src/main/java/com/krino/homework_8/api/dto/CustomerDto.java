package com.danila.homework_8.api.dto;

import com.danila.homework_8.core.model.value.Address;
import lombok.Data;

@Data
public class CustomerDto {
    private Long id;
    private String name;
    private Address address;
}