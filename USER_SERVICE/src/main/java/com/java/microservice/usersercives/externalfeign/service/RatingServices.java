package com.java.microservice.usersercives.externalfeign.service;

import com.java.microservice.usersercives.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="RATING-SERVICE")
public interface RatingServices {

    //post
    @PostMapping("/ratings")
    Rating createRating(@RequestBody Rating rating);
  //  Rating createRating(Map<String,Object>values);  //if you don't have define class in your service then used this
    //get

  //put
    @PutMapping("/ratings/{ratingId}")
     Rating updateRating(@RequestBody  Rating rating,@PathVariable String ratingId);


    //Delete
    @DeleteMapping("/ratings/{ratingId}")
    void DeleteRating(@PathVariable String ratingId);
}
