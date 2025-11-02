package com.saloon.booking_service.dto;

import lombok.Data;

@Data
public class SaloonReport {

    private Integer saloonId;

    private String saloonName;

    private Double totalEarnings;

    private Integer totalBookings;

    private Integer cancelledBookings;

    private Double totalRefund;
}
