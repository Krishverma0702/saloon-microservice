package com.saloon.saloonService.service.impl;
import com.saloon.saloonService.dto.SaloonDTO;
import com.saloon.saloonService.dto.UserDTO;
import com.saloon.saloonService.model.Saloon;
import com.saloon.saloonService.repository.SaloonRepository;
import com.saloon.saloonService.service.SaloonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaloonServiceImpl implements SaloonService {

    private final SaloonRepository saloonRepository;

    @Override
    public Saloon createSaloon(SaloonDTO req, UserDTO user) {
        Saloon saloon = new Saloon();
        saloon.setName(req.getName());
        saloon.setAddress(req.getAddress());
        saloon.setEmail(req.getEmail());
        saloon.setCity(req.getCity());
        saloon.setImages(req.getImages());
        saloon.setOwnerId(req.getOwnerId());
        saloon.setOpenTime(req.getOpenTime());
        saloon.setCloseTime(req.getCloseTime());
        saloon.setPhoneNumber(req.getPhoneNumber());

        return saloonRepository.save(saloon);
    }

    @Override
    public Saloon updateSaloon(SaloonDTO saloon, UserDTO user, int saloonId) throws Exception {

        Saloon existingSaloon= saloonRepository.findById(saloonId).orElse(null);
        if(existingSaloon != null){
            existingSaloon.setCity(saloon.getCity());
            existingSaloon.setName(saloon.getName());
            existingSaloon.setAddress(saloon.getAddress());
            existingSaloon.setEmail(saloon.getEmail());
            existingSaloon.setImages(saloon.getImages());
            existingSaloon.setOpenTime(saloon.getOpenTime());
            existingSaloon.setCloseTime(saloon.getCloseTime());
            existingSaloon.setPhoneNumber(saloon.getPhoneNumber());
            existingSaloon.setOwnerId(user.getId());

            return saloonRepository.save(existingSaloon);
        }

        throw new Exception("Saloon not exist");
    }

    @Override
    public List<Saloon> getAllSaloons() {
        return saloonRepository.findAll();
    }

    @Override
    public Saloon getSaloonById(int saloonId) throws Exception {
        Saloon saloon = saloonRepository.findById(saloonId).orElse(null);
        if(saloon == null){
            throw new Exception("Saloon not found");
        }
        return saloon;
    }

    @Override
    public Saloon getSaloonByOwnerId(int ownerId) {
        return saloonRepository.findByOwnerId(ownerId);
    }

    @Override
    public List<Saloon> searchSaloonByCityName(String city) {
        return saloonRepository.searchSaloons(city);
    }
}
