package com.losnullpointer.elgranpostor.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BuscarSubastaException extends Exception{
    public BuscarSubastaException(String msg){
        super(msg);
    }
}
