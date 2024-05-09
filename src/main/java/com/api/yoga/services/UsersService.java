package com.api.yoga.services;


import com.api.yoga.controllers.UsersController;
import com.api.yoga.models.UsersModel;
import com.api.yoga.repositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsersService {

    final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }
    public UsersModel createUser(UsersModel user) {
        return usersRepository.save(user);
    }

    public List<UsersModel> findAll(){
        return usersRepository.findAll();
    }


    public boolean existsByEmail(String email){
        return usersRepository.existsByEmail(email);
    }


    public Optional<UsersModel> findById(UUID id) {
        return usersRepository.findById(id);
    }
}
