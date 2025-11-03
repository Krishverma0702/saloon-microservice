package com.saloon.payment_service.dto.request;

import lombok.Data;

@Data
public class SaloonReport {

    private Integer saloonId;

    private String saloonName;

    private int totalEarnings;

    private Integer totalBookings;

    private Integer cancelledBookings;

    private Double totalRefund;
}
