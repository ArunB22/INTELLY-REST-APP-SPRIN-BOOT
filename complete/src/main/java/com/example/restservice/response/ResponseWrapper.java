package com.example.restservice.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseWrapper<T> extends ResponseEntity<T> {
    public ResponseWrapper( T t, HttpStatus status )
    {
        super( ( T ) new Resultset<>( t, status ), status );
    }
}
