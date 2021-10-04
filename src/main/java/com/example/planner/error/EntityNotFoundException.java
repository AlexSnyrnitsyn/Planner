package com.example.planner.error;

import com.example.planner.enums.ResponseCode;

public class EntityNotFoundException extends RuntimeException {

    private ResponseCode responseCode;

    public EntityNotFoundException(ResponseCode responseCode){
        this.responseCode = responseCode;
    }

    public ResponseCode getResponseCode(){
        return responseCode;
    }
}
