package com.java.microservice.usersercives.exceptions;

public class ResourceNotFoundException extends RuntimeException {
//extra property you can add to manage your application
    public ResourceNotFoundException(){
        super("Resource not found on the server...!!!");
    }

    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
