package com.saloon.booking_service.repository;

import com.saloon.booking_service.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findByCustomerId(Integer customerId);

    List<Booking> findBySaloonId(Integer saloonId);
}
