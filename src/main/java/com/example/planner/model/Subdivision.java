package com.example.planner.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subdivision", schema = "public")
@Data
public class Subdivision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subdivision_name")
    private String subdivisionName;

    @OneToMany(mappedBy = "userSubdivision")
    private List<User> users;

}
