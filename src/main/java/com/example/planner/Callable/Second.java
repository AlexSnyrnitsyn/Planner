package com.example.planner.Callable;

import org.springframework.stereotype.Component;

@Component
public class Second implements StringCallable {
    @Override
    public String getString() {
        return "classSecond";
    }
}
