package com.saloon.payment_service.dto.request;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class SaloonDTO {

    private Integer id;

    private String name;

    private List<String> images;

    private String address;

    private String phoneNumber;

    private String email;

    private String city;

    private int ownerId;

    private UserDTO owner;

    private LocalTime openTime;

    private LocalTime closeTime;
}
