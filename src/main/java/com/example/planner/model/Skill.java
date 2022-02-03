package com.example.planner.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "skill", schema = "public")
public class Skill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "skill_name")
    private String skillName;

    @Column(name = "description")
    private String description;

    @Column(name = "first_Grade")
    private String firstGrade;

    @Column(name = "second_Grade")
    private String secondGrade;

    @Column(name = "third_Grade")
    private String thirdGrade;

    @Column(name = "fourth_Grade")
    private String fourthGrade;

    @Column(name = "fifth_Grade")
    private String fifthGrade;

    @OneToMany(mappedBy = "skill")
    private List<UserSkill> userSkills;

}
