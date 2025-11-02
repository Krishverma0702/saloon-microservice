package com.saloon.booking_service.dto;

import lombok.Data;

@Data
public class ServiceDTO {
    private Integer id;

    private String name;

    private String description;

    private int price;

    private int duration;

    private Integer saloonId;

    private Integer category;

    private String image;
}
