package com.java.microservice.service.impl;

import com.java.microservice.entities.Hotel;
import com.java.microservice.exceptions.ResourceNotFoundException;
import com.java.microservice.repository.HotelRepository;
import com.java.microservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {


    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        String randId=UUID.randomUUID().toString();
         hotel.setHotelId(randId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("hotel with given Id is not present on data base"+hotelId));
    }
}
