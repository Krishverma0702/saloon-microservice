package com.saloon.saloonService.service;

import com.saloon.saloonService.dto.SaloonDTO;
import com.saloon.saloonService.dto.UserDTO;
import com.saloon.saloonService.model.Saloon;

import java.util.List;

public interface SaloonService {

    Saloon createSaloon(SaloonDTO saloon, UserDTO user);

    Saloon updateSaloon(SaloonDTO saloon, UserDTO user, int saloonId) throws Exception;

    List<Saloon> getAllSaloons();

    Saloon getSaloonById(int saloonId) throws Exception;

    Saloon getSaloonByOwnerId(int ownerId);

    List<Saloon> searchSaloonByCityName(String city);
}
