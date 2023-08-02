package com.java.microservice.service.impl;

import com.java.microservice.entities.Rating;
import com.java.microservice.repository.RatingRepository;
import com.java.microservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

  @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating saveRating(Rating rating) {
        String randId= UUID.randomUUID().toString();
        rating.setRatingId(randId);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
