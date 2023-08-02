package com.java.microservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RATING")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    @Id
    @Column(name="RATING_ID")
    private String ratingId;
    @Column(name="USER_ID")
    private String userId;
    @Column(name = "HOTEL_ID")
    private String hotelId;
    @Column(name = "RATING")
    private int rating;
    @Column(name = "FEEDBACK")
    private String feedback;

}
