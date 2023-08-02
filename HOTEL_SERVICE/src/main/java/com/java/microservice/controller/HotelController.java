package com.java.microservice.controller;

import com.java.microservice.entities.Hotel;
import com.java.microservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

  @Autowired
  private HotelService hotelService;

  @PostMapping
  public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
      return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
  }

  @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
      return ResponseEntity.ok(hotelService.getHotel(hotelId));
  }

  @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel(){
      return ResponseEntity.ok(hotelService.getAllHotel());
  }

}
