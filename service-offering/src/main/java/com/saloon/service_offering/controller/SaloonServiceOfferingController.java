package com.saloon.service_offering.controller;

import com.saloon.service_offering.dto.CategoryDTO;
import com.saloon.service_offering.dto.SaloonDTO;
import com.saloon.service_offering.dto.ServiceDTO;
import com.saloon.service_offering.model.ServiceOffering;
import com.saloon.service_offering.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/service-offering/saloon-owner")
public class SaloonServiceOfferingController {
    private final ServiceOfferingService serviceOfferingService;

    @PostMapping
    public ResponseEntity<ServiceOffering> createService(@RequestBody ServiceDTO serviceDTO) {

        SaloonDTO saloonDTO = new SaloonDTO();
        saloonDTO.setId(1);

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(serviceDTO.getCategory());

        ServiceOffering serviceOfferings = serviceOfferingService.createService(saloonDTO, serviceDTO, categoryDTO);

        return ResponseEntity.ok(serviceOfferings);
    }

    @PostMapping("{id}")
    public ResponseEntity<ServiceOffering> createService(@PathVariable Integer id, @RequestBody ServiceOffering serviceOffering) throws Exception {

        ServiceOffering serviceOfferings = serviceOfferingService.updateService(id, serviceOffering);

        return ResponseEntity.ok(serviceOfferings);
    }


}
