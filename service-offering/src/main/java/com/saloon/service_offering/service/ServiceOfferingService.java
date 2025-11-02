package com.saloon.service_offering.service;

import com.saloon.service_offering.dto.CategoryDTO;
import com.saloon.service_offering.dto.SaloonDTO;
import com.saloon.service_offering.dto.ServiceDTO;
import com.saloon.service_offering.model.ServiceOffering;

import java.util.List;
import java.util.Set;

public interface ServiceOfferingService {

    ServiceOffering createService(SaloonDTO saloonDTO, ServiceDTO serviceDTO, CategoryDTO categoryDTO);

    ServiceOffering updateService(Integer serviceId, ServiceOffering service) throws Exception;

    Set<ServiceOffering> getAllServiceBySaloonId(Integer saloonId, Integer categoryId);

    Set<ServiceOffering> getServicesById(Set<Integer> id);

    ServiceOffering getServiceById(Integer id) throws Exception;
}
