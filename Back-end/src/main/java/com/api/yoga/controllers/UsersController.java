package com.api.yoga.controllers;


import com.api.yoga.models.UsersModel;
import com.api.yoga.repositories.UsersRepository;
import com.api.yoga.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins= "*", maxAge = 3600)
@RequestMapping("/users")
public class UsersController {

    UsersModel userModel = new UsersModel();

    final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }


    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody UsersModel user) {
        Optional<UsersModel> usersModelOptional = usersService.findByEmail(user.getEmail());

        if (usersModelOptional.isPresent()) {
            UsersModel existingUser = usersModelOptional.get();
            if (existingUser.getPassword().equals(user.getPassword())) { // Comparação de senha simples
                return ResponseEntity.status(HttpStatus.OK).body("Login bem-sucedido");
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senha incorretos");
    }


    @PostMapping("/create")//adiciona usuario
    public ResponseEntity<Object> createUser(@RequestBody UsersModel user) {
        if(usersService.existsByEmail(user.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Email is already in use!");
        }

        UsersModel newUser = usersService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping //busca todos os usuarios
    public ResponseEntity<List<UsersModel>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(usersService.findAll());
    }

    @GetMapping("/{id}")//busca usuario pelo ID
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "id") UUID id){
        Optional<UsersModel> usersModelOptional = usersService.findById(id);

        if(!usersModelOptional.isPresent()){ //verifica o ID se existe
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usersModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") UUID id){
        Optional<UsersModel> usersModelOptional = usersService.findById(id);
        if(!usersModelOptional.isPresent()){ //verifica o ID se existe
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        usersService.delete(usersModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(usersModelOptional.get());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "id") UUID id, @RequestBody UsersModel user) {
        Optional<UsersModel> usersModelOptional = usersService.findById(id);

        if(!usersModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        UsersModel existingUser = usersModelOptional.get();
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());

        UsersModel updatedUser = usersService.updateUser(existingUser);

        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

}
