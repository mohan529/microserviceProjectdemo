package com.java.microservice.service;

import com.java.microservice.entities.Rating;

import java.util.List;

public interface RatingService {

    Rating saveRating(Rating rating);
    List<Rating> getAllRating();
    List<Rating>getByUserId(String userId);
    List<Rating> getByHotelId(String hotelId);

}
