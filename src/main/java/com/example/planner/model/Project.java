package com.example.planner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "project", schema = "public")
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "goal_project")
    private String goalProject;

    @Column(name = "complexity_project")
    private String complexityProject;

    @ManyToMany
    @JoinTable(name = "project_user", joinColumns = @JoinColumn(name = "project_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set <User> users;

}
