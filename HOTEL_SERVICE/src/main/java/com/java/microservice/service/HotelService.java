package com.java.microservice.service;

import com.java.microservice.entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel createHotel(Hotel hotel);

    List<Hotel> getAllHotel();
     Hotel getHotel(String hotelId);
}
