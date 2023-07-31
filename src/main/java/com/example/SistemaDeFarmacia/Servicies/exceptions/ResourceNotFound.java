package com.example.SistemaDeFarmacia.Servicies.exceptions;

public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound(String msg){
        super(msg);
    }
}
