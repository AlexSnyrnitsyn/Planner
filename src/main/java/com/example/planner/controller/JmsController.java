package com.example.planner.controller;

import com.example.planner.model.User;

public interface JmsController {

    void topic(User user);
}
