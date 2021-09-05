package com.example.planner.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "position", schema = "public")
@Data
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "position_name")
    private String positionName;

    @OneToMany(mappedBy = "userPosition")
    private List<User> users;

}
