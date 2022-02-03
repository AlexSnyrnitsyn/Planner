package com.example.planner.enums;

import com.example.planner.Callable.First;

public enum EnumClasses {
    FIRST("first"),
    SECOND("second"),
    THIRD("third");

    private String discription;

    EnumClasses(String discription) {
        this.discription = discription;
    }

    public String getDiscription(){
        return discription;
    }
}
