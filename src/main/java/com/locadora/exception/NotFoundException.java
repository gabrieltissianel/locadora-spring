package com.locadora.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String className){
        super(className + " não encontrado.");
    }
}
