package com.example.planner.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "subdivision", schema = "public")
@Getter
@Setter
public class Subdivision implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subdivision_name")
    private String subdivisionName;

    @OneToMany(mappedBy = "userSubdivision")
    private List<User> users;

}
