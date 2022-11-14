package com.example.userservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class UserController {

    @GetMapping("/user/{id}")
    public ResponseEntity<BigInteger> getUser(@PathVariable(value = "id")BigInteger id){
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}