package com.example.planner.Callable;

import org.springframework.stereotype.Component;

@Component
public class Third implements StringCallable {
    @Override
    public String getString() {
        return "classThird";
    }
}
