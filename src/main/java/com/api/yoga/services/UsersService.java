package com.api.yoga.services;


import com.api.yoga.controllers.UsersController;
import com.api.yoga.repositories.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

}
