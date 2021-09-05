package com.example.planner.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "user", schema = "public")
@Data
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<UserSkill> userSkills;

    @Id
    @Column(name = "position_id")
    private Long positionId;

    @Id
    @Column(name = "subdivision_id")
    private Long subdivisionId;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private User userPosition;

    @ManyToOne
    @JoinColumn(name = "subdivision_id")
    private User userSubdivision;

}
