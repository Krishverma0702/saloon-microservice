package com.saloon.saloonService.repository;

import com.saloon.saloonService.model.Saloon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SaloonRepository extends JpaRepository<Saloon, Integer> {

    Saloon findByOwnerId(int id);

    @Query(
            "select s from Saloon s where" +
                    "(lower(s.city) like lower(concat('%', :keyword, '%') ) OR " +
                    "lower(s.name) like lower(concat('%', :keyword, '%') ) OR " +
                    "lower(s.address) like lower(concat('%', :keyword, '%') ) )"
    )
    List<Saloon> searchSaloons(@Param("keyword") String keyword);
}
