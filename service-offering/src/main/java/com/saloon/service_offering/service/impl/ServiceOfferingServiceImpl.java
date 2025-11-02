package com.saloon.service_offering.service.impl;

import com.saloon.service_offering.dto.CategoryDTO;
import com.saloon.service_offering.dto.SaloonDTO;
import com.saloon.service_offering.dto.ServiceDTO;
import com.saloon.service_offering.model.ServiceOffering;
import com.saloon.service_offering.repository.ServiceOfferingRepository;
import com.saloon.service_offering.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceOfferingServiceImpl implements ServiceOfferingService {

    private final ServiceOfferingRepository serviceOfferingRepository;

    @Override
    public ServiceOffering createService(SaloonDTO saloonDTO, ServiceDTO serviceDTO, CategoryDTO categoryDTO) {
        ServiceOffering serviceOffering = new ServiceOffering();

        serviceOffering.setImage(serviceDTO.getImage());
        serviceOffering.setSaloonId(saloonDTO.getId());
        serviceOffering.setName(serviceDTO.getName());
        serviceOffering.setDescription(serviceDTO.getDescription());
        serviceOffering.setCategoryId(categoryDTO.getId());
        serviceOffering.setPrice(serviceDTO.getPrice());
        serviceOffering.setDuration(serviceDTO.getDuration());

        return serviceOfferingRepository.save(serviceOffering);
    }

    @Override
    public ServiceOffering updateService(Integer serviceId, ServiceOffering service) throws Exception {

        ServiceOffering serviceOffering = serviceOfferingRepository.findById(serviceId).orElse(null);

        if (serviceOffering == null) {
            throw new Exception("Service not exist with id" + serviceId);
        }

        serviceOffering.setImage(service.getImage());
        serviceOffering.setName(service.getName());
        serviceOffering.setDescription(service.getDescription());
        serviceOffering.setPrice(service.getPrice());
        serviceOffering.setDuration(service.getDuration());

        return serviceOfferingRepository.save(serviceOffering);
    }

    @Override
    public Set<ServiceOffering> getAllServiceBySaloonId(Integer saloonId, Integer categoryId) {


        Set<ServiceOffering> services = serviceOfferingRepository.findBySaloonId(saloonId);

        if (categoryId != null) {
            services = services.stream().filter((service) ->
                    service.getCategoryId() != null &&
                            service.getCategoryId() == categoryId).collect(Collectors.toSet());
        }

        return services;
    }

    @Override
    public Set<ServiceOffering> getServicesById(Set<Integer> id) {
        List<ServiceOffering> services = serviceOfferingRepository.findAllById(id);

        return new HashSet<>(services);
    }

    @Override
    public ServiceOffering getServiceById(Integer id) throws Exception {
        ServiceOffering serviceOffering = serviceOfferingRepository.findById(id).orElse(null);

        if(serviceOffering == null) {
            throw new Exception("Service not exist with id: " + id);
        }

        return serviceOffering;
    }
}
