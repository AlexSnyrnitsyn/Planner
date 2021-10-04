package com.example.planner.controller;

import com.example.planner.dto.PlannerExceptionDto;
import com.example.planner.error.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class PlannerExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<PlannerExceptionDto> handleException(EntityNotFoundException ex){
        PlannerExceptionDto plannerExceptionDto = new PlannerExceptionDto();
        plannerExceptionDto.setMassage(ex.getResponseCode().getMessage());
        return new ResponseEntity<>(plannerExceptionDto, HttpStatus.NOT_FOUND);
    }
}
