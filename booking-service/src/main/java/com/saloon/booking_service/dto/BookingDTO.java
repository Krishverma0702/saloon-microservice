package com.saloon.booking_service.dto;

import com.saloon.booking_service.domain.BookingStatus;
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

    private BookingStatus status = BookingStatus.PENDING;
}
