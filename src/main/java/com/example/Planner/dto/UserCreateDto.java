package com.example.planner.dto;

public class UserCreateDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String login;


    public UserCreateDto(Long id, String firstName, String lastName, String login) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }




}
