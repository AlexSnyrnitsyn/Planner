package com.example.planner.enums;

public enum  ResponseCode {

    USER_NOT_FOUND("Ползователь не найден"),
    SKILL_NOT_FOUND("Навык не найден"),
    POSITION_NOT_FOUND("Позиция не найдена"),
    SUBDIVISION_NOT_FOUND("Подразделение не найдено"),
    USER_SKILL_NOT_FOUND("Связка не найдена"),
    PROJECT_NOT_FOUND("Проект не найден");


    private String message;

    ResponseCode(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
