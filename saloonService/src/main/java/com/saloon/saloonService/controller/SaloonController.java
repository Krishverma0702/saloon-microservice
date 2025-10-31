package com.saloon.saloonService.controller;

import com.saloon.saloonService.dto.SaloonDTO;
import com.saloon.saloonService.dto.UserDTO;
import com.saloon.saloonService.mapper.SaloonMapper;
import com.saloon.saloonService.model.Saloon;
import com.saloon.saloonService.service.SaloonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/saloons")
public class SaloonController {
    private final SaloonService saloonService;

    //http://localhost:8080/api/saloons
    @PostMapping
    public ResponseEntity<SaloonDTO> createSaloon(@RequestBody SaloonDTO saloonDTO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1);
        Saloon saloon = saloonService.createSaloon(saloonDTO, userDTO);

        SaloonDTO saloonDTO1 = SaloonMapper.mapToDTO(saloon);

        return ResponseEntity.ok(saloonDTO1);
    }

    //http://localhost:8080/api/saloons/id
    @PatchMapping("/{saloonId}")
    public ResponseEntity<SaloonDTO> updateSaloon(@PathVariable int saloonId, @RequestBody SaloonDTO saloonDTO) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1);

        Saloon saloon = saloonService.updateSaloon(saloonDTO, userDTO, saloonId);
        SaloonDTO saloonDTO1 = SaloonMapper.mapToDTO(saloon);

        return ResponseEntity.ok(saloonDTO1);
    }

    //http://localhost:8080/api/saloons
    @GetMapping
    public ResponseEntity<List<SaloonDTO>> getSaloons() {
        List<Saloon> allSaloons = saloonService.getAllSaloons();

        List<SaloonDTO> saloonDTOS = allSaloons.stream().map((saloons) -> {
            SaloonDTO saloonDTO = SaloonMapper.mapToDTO(saloons);
            return saloonDTO;
        }).toList();

        return ResponseEntity.ok(saloonDTOS);
    }

    @GetMapping("/{saloonId}")
    public ResponseEntity<SaloonDTO> getSaloonsById(@PathVariable int saloonId) throws Exception {
        Saloon saloon = saloonService.getSaloonById(saloonId);

        SaloonDTO saloonDTO = SaloonMapper.mapToDTO(saloon);

        return ResponseEntity.ok(saloonDTO);
    }


    @GetMapping("/search")
    public ResponseEntity<List<SaloonDTO>> searchSaloons(@RequestParam("city") String city) throws Exception {
        List<Saloon> allSaloons = saloonService.searchSaloonByCityName(city);

        List<SaloonDTO> saloonDTOS = allSaloons.stream().map((saloons) -> {
            SaloonDTO saloonDTO = SaloonMapper.mapToDTO(saloons);
            return saloonDTO;
        }).toList();

        return ResponseEntity.ok(saloonDTOS);
    }


    @GetMapping("/owner")
    public ResponseEntity<SaloonDTO> getSaloonsByOwnerId(@PathVariable int saloonId) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1);

        Saloon saloon = saloonService.getSaloonByOwnerId(userDTO.getId());

        SaloonDTO saloonDTO = SaloonMapper.mapToDTO(saloon);

        return ResponseEntity.ok(saloonDTO);
    }
}
