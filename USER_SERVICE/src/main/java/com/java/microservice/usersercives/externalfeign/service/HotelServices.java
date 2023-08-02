package com.java.microservice.usersercives.externalfeign.service;

import com.java.microservice.usersercives.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelServices {


    @GetMapping("/hotels/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);

}
