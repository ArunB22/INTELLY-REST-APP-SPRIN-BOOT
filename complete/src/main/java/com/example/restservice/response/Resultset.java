package com.example.restservice.response;

import com.example.restservice.exception.ResourceNotFoundException;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class Resultset<T> {

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private T data;

    private Resultset()
    {
        this.timestamp = LocalDateTime.now();
    }

    public Resultset( T o, HttpStatus status ) throws ResourceNotFoundException
    {
        this();
        if ( o == null || ( o instanceof List && ( ( List ) o ).isEmpty() ) )
            throw new ResourceNotFoundException( "No Content Found" );
        this.status = status;
        this.data = o;
    }
}
