package com.example.planner.model;


import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "user_skill", schema = "public")
public class UserSkill {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "skill_id")
    private Long skillId;

    @Column(name = "grade")
    private int grade;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

}
