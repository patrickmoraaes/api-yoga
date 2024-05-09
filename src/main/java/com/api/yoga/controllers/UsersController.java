package com.api.yoga.controllers;


import com.api.yoga.models.UsersModel;
import com.api.yoga.repositories.UsersRepository;
import com.api.yoga.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins= "*", maxAge = 3600)
@RequestMapping("/Cadastro-user")
public class UsersController {

    UsersModel userModel = new UsersModel();

    final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody UsersModel user) {

        if(usersService.existsByEmail(userModel.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Email is already in use!");
        }

        UsersModel newUser = usersService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }



}
