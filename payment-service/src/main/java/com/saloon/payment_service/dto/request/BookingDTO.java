package com.saloon.payment_service.dto.request;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class BookingDTO {

    private Integer id;

    private Integer saloonId;

    private Integer customerId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Set<Integer> serviceIds;

    private int totalPrice;
}
