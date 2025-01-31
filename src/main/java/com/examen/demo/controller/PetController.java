package com.examen.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.examen.demo.model.Pet;
import com.examen.demo.model.Transaction;
import com.examen.demo.service.PetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class PetController {

    @Autowired
    PetService petService;

    @GetMapping("api/pet/{id}")
    public Pet getMethodName(@PathVariable Long id) {
        // consumo de la url: https://petstore.swagger.io/v2/pet/{id}
        // PetService petService = new PetService();
        return petService.getPetById(id);

    }

    @PostMapping("api/pet")
    public Transaction potMethodName(@RequestBody Pet pet) {
        // consumo de la url: https://petstore.swagger.io/v2/pet/{id}
        // PetService petService = new PetService();
        return petService.saveTransaction(pet);

    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
