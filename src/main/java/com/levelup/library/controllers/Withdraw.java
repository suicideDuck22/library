package com.levelup.library.controllers;

import com.levelup.library.entities.WithdrawEntity;
import com.levelup.library.repositories.WithdrawRepository;
import com.levelup.library.services.WithdrawServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/withdraw")
public class Withdraw {
    @Autowired
    private WithdrawServiceImpl withdrawService;

    @GetMapping("/")
    ResponseEntity<Map<String, Collection<WithdrawEntity>>> getAll(){
        Map<String, List<WithdrawEntity>> responseObject = new HashMap<>();
        List<WithdrawEntity> withdraws =  withdrawService.getAll();

        responseObject.put("withdraws", withdraws);
        return new ResponseEntity(responseObject, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Map<String, WithdrawEntity>> get(@PathVariable Long id){
        Map<String, WithdrawEntity> responseObject = new HashMap<>();
        responseObject.put("withdraw", withdrawService.get(id));

        return new ResponseEntity(responseObject, HttpStatus.OK);
    }
}
