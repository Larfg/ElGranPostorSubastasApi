package com.losnullpointer.elgranpostor.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CrearSubastaException extends Exception {

    public CrearSubastaException(String errorMessage){
        super(errorMessage);
    }

}
