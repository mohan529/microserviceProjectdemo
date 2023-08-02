package com.java.microservice.usersercives.entities;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Hotel {

    private String hotelId;
    private String name;
    private String location;
    private String about;
}
