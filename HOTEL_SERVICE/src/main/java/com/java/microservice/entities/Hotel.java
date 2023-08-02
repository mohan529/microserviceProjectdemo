package com.java.microservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HOTEL")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Hotel {

    @Id
    @Column(name="HOTEL_ID")
    private String hotelId;
    @Column(name="HOTEL_NAME")
    private String name;
    @Column(name="LOCATION")
    private String location;
    @Column(name="ABOUT")
    private String about;
}
