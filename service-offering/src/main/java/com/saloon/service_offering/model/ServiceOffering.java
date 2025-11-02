package com.saloon.service_offering.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ServiceOffering {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private Integer saloonId;

    @Column(nullable = false)
    private Integer categoryId;

    private String image;
}
