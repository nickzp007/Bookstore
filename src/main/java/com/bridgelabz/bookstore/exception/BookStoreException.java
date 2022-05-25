package com.bridgelabz.bookstore.exception;

import com.bridgelabz.bookstore.dto.ResponseDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@Data
//custom ex
public class BookStoreException extends RuntimeException{
    public BookStoreException(String message){
        super(message);//call the constructor of run time ex.
    }

}