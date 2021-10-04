package com.example.planner.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user", schema = "public")
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position userPosition;

    @ManyToOne
    @JoinColumn(name = "subdivision_id")
    private Subdivision userSubdivision;

}
