package com.saloon.booking_service.service;

import com.saloon.booking_service.domain.BookingStatus;
import com.saloon.booking_service.dto.*;
import com.saloon.booking_service.model.Booking;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BookingService {

    Booking createBooking(BookingRequest booking, UserDTO user, SaloonDTO saloon, Set<ServiceDTO> serviceDTOSet) throws Exception;

    List<Booking> getBookingsByCustomer(Integer customerId);

    List<Booking> getBookingsBySaloon(Integer saloonId) throws Exception;

    Booking getBookingId(Integer id) throws Exception;

    Booking updateBooking(Integer bookingId, BookingStatus status) throws Exception;

    List<Booking> getBookingsByDate(LocalDate date, Integer saloonId) throws Exception;

    SaloonReport getSaloonReport(Integer saloonId) throws Exception;
}
