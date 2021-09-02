package com.example.planner.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "user_skill", schema = "public")
public class UserToSkill {


    @Id
    private Long userId;

    @Id
    private Long skillId;

    @Column(name = "grade")
    private String grade;
}
