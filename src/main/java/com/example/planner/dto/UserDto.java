package com.example.planner.dto;

import lombok.*;

@Setter
@Getter
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private Long positionId;
    private Long subdivisionId;

}
