package com.java.microservice.usersercives.entities;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Micro_USER")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name="id",length = 50)
    private String userId;
    @Column(name="USER_NAME")
    private String Name;
    @Column(name="EMAIL")
    private String email;
    @Column(name="ABOUT")
    private String about;

    @Transient
    private List<Rating> ratings=new ArrayList<>();
}
