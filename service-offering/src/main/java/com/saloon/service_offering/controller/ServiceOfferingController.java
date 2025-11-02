package com.saloon.service_offering.controller;

import com.saloon.service_offering.model.ServiceOffering;
import com.saloon.service_offering.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/service-offering")
public class ServiceOfferingController {

    private final ServiceOfferingService serviceOfferingService;

    @GetMapping("/salon/{saloonId}")
    public ResponseEntity<Set<ServiceOffering>> getServiceBySaloonId(@PathVariable Integer saloonId,
                                                                     @RequestParam(required = false) Integer categoryId) {
        Set<ServiceOffering> serviceOfferings = serviceOfferingService.getAllServiceBySaloonId(saloonId, categoryId);

        return ResponseEntity.ok(serviceOfferings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceOffering> getServiceById(@PathVariable Integer id) throws Exception {
        ServiceOffering serviceOffering = serviceOfferingService.getServiceById(id);

        return ResponseEntity.ok(serviceOffering);
    }

    @GetMapping("/list/{ids}")
    public ResponseEntity<Set<ServiceOffering>> getServiceById(@PathVariable Set<Integer> ids) throws Exception {
        Set<ServiceOffering> serviceOfferings = serviceOfferingService.getServicesById(ids);

        return ResponseEntity.ok(serviceOfferings);
    }

}
