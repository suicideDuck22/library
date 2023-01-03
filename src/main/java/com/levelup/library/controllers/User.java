package com.levelup.library.controllers;

import com.levelup.library.entities.UserEntity;
import com.levelup.library.repositories.UserRepository;
import jakarta.validation.Valid;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class User {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/create")
    String createUserPage(){
        return "Rendering create user page";
    }

    @PostMapping(
            value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Map<String, String>> createUser(@RequestBody @Valid UserEntity newUser){
        Map<String, String> responseObject = new HashMap<>();
        Optional<String> searchEmailResponse = Optional.ofNullable(userRepository.findByEmail(newUser.getEmail()));

        if(searchEmailResponse.isPresent()){
            responseObject.put("error", "Email in use");
            responseObject.put("message", "This email has been in use by another user, please try another.");
            return new ResponseEntity(responseObject, HttpStatus.BAD_REQUEST);
        }

        newUser.setPassword(DigestUtils.sha256Hex(newUser.getPassword()));

        userRepository.save(newUser);
        responseObject.put("message", "User created successfully.");
        return new ResponseEntity(responseObject, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Map<String, String>> deleteUser(@PathVariable Long id) {
        Map<String, String> responseObject = new HashMap<>();
        Optional<UserEntity> userToDelete = Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("User with ID " + id + " not founded.");
        }));

        responseObject.put("teste", "teste");
        System.out.println("existe");
        return new ResponseEntity(responseObject, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    Map<String, String> handleNoSuchElementException(NoSuchElementException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        error.put("message", "User not found.");
        return error;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SQLException.class)
    Map<String, String> handleSQLException(SQLException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        error.put("message", "An error occurred on try create the new user, please try again.");
        return error;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
        Map <String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
