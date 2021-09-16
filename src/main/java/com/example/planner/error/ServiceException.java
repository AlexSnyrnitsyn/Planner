package com.example.planner.error;

import com.example.planner.enums.ResponseCode;

public class ServiceException extends Exception {

    private ResponseCode responseCode;

    public ServiceException(ResponseCode responseCode){
        this.responseCode = responseCode;
    }

    public ResponseCode getResponseCode(){
        return responseCode;
    }

}
