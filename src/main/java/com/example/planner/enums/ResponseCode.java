package com.example.planner.enums;

public enum  ResponseCode {

    WRONG_USER("Ползователь не найден"),
    WRONG_SKILL("Навык не найден"),
    WRONG_POSITION("Позиция не найдена"),
    WRONG_SUBDIVISION("Подразделение не найдено"),
    WRONG_USER_SKILL("Связка не найдена");



    private String message;

    ResponseCode(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
