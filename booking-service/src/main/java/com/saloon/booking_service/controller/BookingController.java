package com.saloon.booking_service.controller;

import com.saloon.booking_service.domain.BookingStatus;
import com.saloon.booking_service.dto.*;
import com.saloon.booking_service.mapper.BookingMapper;
import com.saloon.booking_service.model.Booking;
import com.saloon.booking_service.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public ResponseEntity<Booking> createBooking(@RequestParam Integer saloonId, @RequestBody BookingRequest bookingRequest) throws Exception {

        UserDTO user = new UserDTO();
        user.setId(1);

        SaloonDTO saloon = new SaloonDTO();
        saloon.setId(saloonId);
        saloon.setOpenTime(LocalTime.now());
        saloon.setCloseTime(LocalTime.now().plusHours(12));

        Set<ServiceDTO> serviceDTOSet = new HashSet<>();

        ServiceDTO serviceDTO = new ServiceDTO();

        serviceDTO.setId(1);
        serviceDTO.setPrice(399);
        serviceDTO.setDuration(45);
        serviceDTO.setName("Hair cut for men");

        serviceDTOSet.add(serviceDTO);

        Booking booking = bookingService.createBooking(bookingRequest, user, saloon, serviceDTOSet);

        return ResponseEntity.ok(booking);
    }

    @GetMapping("/customer")
    public ResponseEntity<Set<BookingDTO>> getBookingsByCustomer() {
        List<Booking> bookings = bookingService.getBookingsByCustomer(1);
        return ResponseEntity.ok(getBookingDTOs(bookings));
    }

    @GetMapping("/saloon")
    public ResponseEntity<Set<BookingDTO>> getBookingsBySaloon() throws Exception {
        List<Booking> bookings = bookingService.getBookingsBySaloon(1);
        return ResponseEntity.ok(getBookingDTOs(bookings));
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable Integer bookingId) throws Exception {

        Booking booking = bookingService.getBookingById(bookingId);
        return ResponseEntity.ok(BookingMapper.toDTO(booking));
    }

    @PutMapping("/{bookingId}/status")
    public ResponseEntity<BookingDTO> updateBookingStatus(@PathVariable Integer bookingId, @RequestParam BookingStatus status) throws Exception {

        Booking booking = bookingService.updateBooking(bookingId, status);
        return ResponseEntity.ok(BookingMapper.toDTO(booking));
    }

    @GetMapping("/slots/saloon/{saloonId}/date/{date}")
    public ResponseEntity<List<BookingSlotDTO>> getBookedSlot(@PathVariable Integer saloonId, @RequestParam(required = false) LocalDate date) throws Exception {

        List<Booking> bookings = bookingService.getBookingsByDate(date, saloonId);

        List<BookingSlotDTO> slotDTOs = bookings.stream()
                .map(booking -> {
                    BookingSlotDTO slotDTO = new BookingSlotDTO();
                    slotDTO.setStartTime(booking.getStartTime());
                    slotDTO.setEndTime(booking.getEndTime());
                    return slotDTO;
                }).collect(Collectors.toList());
        return ResponseEntity.ok(slotDTOs);
    }

    @GetMapping("/report")
    public ResponseEntity<SaloonReport> getSaloonReport() throws Exception {

        SaloonReport report = bookingService.getSaloonReport(1);
        return ResponseEntity.ok(report);
    }

    private Set<BookingDTO> getBookingDTOs(List<Booking> bookings) {
        return bookings.stream().map(
                booking -> {
                    return BookingMapper.toDTO(booking);
                }).collect(Collectors.toSet());
    }
}
