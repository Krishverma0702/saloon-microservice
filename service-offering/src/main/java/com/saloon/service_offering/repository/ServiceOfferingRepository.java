package com.saloon.service_offering.repository;

import com.saloon.service_offering.model.ServiceOffering;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ServiceOfferingRepository extends JpaRepository<ServiceOffering, Integer> {

    Set<ServiceOffering> findBySaloonId(int id);
}
