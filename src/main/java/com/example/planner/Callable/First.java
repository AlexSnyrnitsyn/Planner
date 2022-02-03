package com.example.planner.Callable;

import org.springframework.stereotype.Component;

@Component
public class First implements StringCallable  {

    @Override
    public String getString() {
        return "classFirst";
    }
}
