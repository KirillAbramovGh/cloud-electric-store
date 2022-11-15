package com.example.userservice.controller;

import com.example.userservice.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final List<User> users = new ArrayList(Arrays.asList(new User(new BigInteger("1"),"Lex","LexLogin","LexPass"),
            new User(new BigInteger("2"),"Den","DenLogin","DenPass")));

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable(value = "id")BigInteger id){
        return new ResponseEntity<>(users.stream()
                .filter(u -> u.getId().equals(id)).findFirst().orElse(null), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        users.add(user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }



}
