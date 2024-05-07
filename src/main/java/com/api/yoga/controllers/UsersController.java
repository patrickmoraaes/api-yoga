package com.api.yoga.controllers;


import com.api.yoga.services.UsersService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins= "*", maxAge = 3600)
@RequestMapping("/Cadastro-user")
public class UsersController {

    final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }
}
