package com.example.planner.controller;

import com.example.planner.Callable.CallString;
import com.example.planner.Callable.First;
import com.example.planner.Callable.StringCallable;
import com.example.planner.enums.EnumClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CallController {

    @Autowired
    Map<String, StringCallable> callableMab;

    CallString callString;

    @Autowired
    public CallController(CallString callString) {
        this.callString = callString;
    }

    @GetMapping
    @RequestMapping("/call")
    public String call(@RequestParam("mode") EnumClasses enumClasses){

        StringCallable stringCallable = callableMab.get(enumClasses.getDiscription());
        return stringCallable.getString();
        
    }

    @GetMapping
    @RequestMapping("/string")
    public String vozvrat(){

        return callString.vozvratStroki();
    }
}
