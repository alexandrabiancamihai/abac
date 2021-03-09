package com.abac.planets.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {

    OK("OK"),
    NOT_OK("!OK"),
    TODO("TODO"),
    EN_ROUTE("EnRoute");

    private String status;

    public String getStatus(){
        return this.status;
    }

    Status(String status){
        this.status = status;
    }
}
