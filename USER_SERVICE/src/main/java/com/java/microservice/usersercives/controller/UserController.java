package com.java.microservice.usersercives.controller;

import com.java.microservice.usersercives.entities.User;
import com.java.microservice.usersercives.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jnlp.UnavailableServiceException;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    private static  Logger log= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){

      return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }

    int retryCount=1;

    @GetMapping("/{userId}")
 //   @CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallBack")
//   @Retry(name="ratingHotelService",fallbackMethod="ratingHotelFallBack")
  @RateLimiter(name="userRateLimiter",fallbackMethod = "ratingHotelFallBack")
    public ResponseEntity<User> getUser(@PathVariable String userId){
        log.info("Retry count:{} ",retryCount);
        retryCount++;
        return ResponseEntity.ok(userService.getUser(userId));
    }

    //creating fall back method for circuitBreaker
    public ResponseEntity<User> ratingHotelFallBack(String userId,Exception ex){
        log.info("Fallback is executed because service is down: ",ex.getMessage());
       User user= User.builder().email("dummy@gmail.com")
                .Name("dummy")
                .about("This is dummy user created because some service is down...!!!")
               .userId("1")
               .build();
        return new  ResponseEntity<>(user,HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users=userService.getAllUser();
        return ResponseEntity.ok(users);
    }


}
