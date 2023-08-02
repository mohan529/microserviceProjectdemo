package com.java.microservice.usersercives.service.impl;

import com.java.microservice.usersercives.entities.Hotel;
import com.java.microservice.usersercives.entities.Rating;
import com.java.microservice.usersercives.entities.User;
import com.java.microservice.usersercives.exceptions.ResourceNotFoundException;
import com.java.microservice.usersercives.externalfeign.service.HotelServices;
import com.java.microservice.usersercives.repositry.UserRepository;
import com.java.microservice.usersercives.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelServices hotelServices;

    private Logger log= LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomId=UUID.randomUUID().toString();
        user.setUserId(randomId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }


    @Override
    public User getUser(String userId) {
        User user= userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id is not found in this server: "+userId));
       //fetch  rating of the above user from the Rating service
     //   localhost:8083/ratings/user/7d6278a4-d7fd-414a-8ad1-319792625792
        Rating [] ratingsOfUsers=restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+user.getUserId(), Rating[].class);
        log.info(" rating {}",ratingsOfUsers);
        List<Rating> ratings=Arrays.stream(ratingsOfUsers).collect(Collectors.toList());
        List<Rating>ratingList=ratings.stream().map(rating -> {

          //localhost:8082/hotels/f698d456-1567-4f1b-9cc8-b25b991481e2
//          ResponseEntity<Hotel> hotelEntity= restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
//                Hotel hotel=hotelEntity.getBody();
//                log.info("hotel status code{}",hotelEntity.getStatusCode());
                Hotel hotel=hotelServices.getHotel(rating.getHotelId());
                rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
    }
}
