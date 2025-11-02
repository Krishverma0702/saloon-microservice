package com.saloon.booking_service.model;

import com.saloon.booking_service.domain.BookingStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer customerId;

    private Integer saloonId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @ElementCollection
    private Set<Integer> serviceIds;

    private BookingStatus status = BookingStatus.PENDING;

    private int totalPrice;
}
