package com.salon.controller;

import com.salon.mapper.SalonMapper;
import com.salon.modal.Salon;
import com.salon.payload.dto.SalonDTO;
import com.salon.payload.dto.UserDTO;
import com.salon.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salons")

public class SalonController {

    @Autowired
    private  SalonService salonsService;

    // http://localhost/api/salons/
    @PostMapping
    public ResponseEntity<SalonDTO> createSalon(@RequestBody SalonDTO salonDTO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Salon salon = salonsService.createSalon(salonDTO, userDTO);
        SalonDTO salonDTO1 =  SalonMapper.mapToDTO(salon);
        return ResponseEntity.ok(salonDTO1);
    }
    // http://localhost/api/salons/69
    @PatchMapping("{salonId}")
    public ResponseEntity<SalonDTO> updateSalon(
            @PathVariable Long salonId,
            @RequestBody SalonDTO salonDTO) throws Exception {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Salon salon = salonsService.updateSalon(salonDTO, userDTO, salonId);
        SalonDTO salonDTO1 =  SalonMapper.mapToDTO(salon);
        return ResponseEntity.ok(salonDTO1);
    }

    // http://localhost/api/salons/
    @GetMapping
    public ResponseEntity<List<SalonDTO>>getSalons() throws Exception {

        List<Salon> salons = salonsService.getAllSalons();

        List<SalonDTO> salonDTOS = salons.stream().map((salon) ->
                {
                    SalonDTO salonDTO = SalonMapper.mapToDTO(salon);
                    return salonDTO;
                }
        ).toList();

        return ResponseEntity.ok(salonDTOS);
    }
    // http://localhost/api/salons/69
    @GetMapping("{salonId}")
    public ResponseEntity<SalonDTO>getSalonById(
            @PathVariable Long salonId
    ) throws Exception {


        Salon salon = salonsService.getSalonById(salonId);
        SalonDTO salonDTO = SalonMapper.mapToDTO(salon);

        return ResponseEntity.ok(salonDTO);
    }

    // http://localhost/api/salons/search?city=Pune
    @GetMapping("/search")
    public ResponseEntity<List<SalonDTO>>searchSalons(
            @RequestParam("city") String city
    ) throws Exception {

        List<Salon> salons = salonsService.searchSalonByCity(city);

        List<SalonDTO> salonDTOS = salons.stream().map((salon) ->
                {
                    SalonDTO salonDTO = SalonMapper.mapToDTO(salon);
                    return salonDTO;
                }
        ).toList();

        return ResponseEntity.ok(salonDTOS);
    }
    // http://localhost/api/salons/69
    @GetMapping("/owner")
    public ResponseEntity<SalonDTO>getSalonByOwnerId(
            @PathVariable Long salonId
    ) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);

        Salon salon = salonsService.getSalonByOwnerId(userDTO.getId());
        SalonDTO salonDTO = SalonMapper.mapToDTO(salon);

        return ResponseEntity.ok(salonDTO);
    }
}