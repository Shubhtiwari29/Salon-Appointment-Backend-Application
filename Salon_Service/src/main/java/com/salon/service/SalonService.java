package com.salon.service;

import com.salon.modal.Salon;
import com.salon.payload.dto.SalonDTO;
import com.salon.payload.dto.UserDTO;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface SalonService {

    Salon createSalon (SalonDTO salonDTO, UserDTO userDTO);

    Salon updateSalon (SalonDTO salonDTO, UserDTO userDTO, Long salonId) throws Exception;

    List<Salon> getAllSalons();

    Salon getSalonById(long salonId) throws Exception;

    Salon getSalonByOwnerId(Long ownerId);

    List<Salon> searchSalonByCity(String city);
}
