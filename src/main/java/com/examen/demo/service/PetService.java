package com.examen.demo.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.demo.model.Pet;
import com.examen.demo.model.Transaction;
import com.examen.demo.model.request.TransactionRequest;
import com.examen.demo.model.response.PetResponse;
import com.examen.demo.repository.PetRepository;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public Pet getPetById(Long id) {
        PetResponse response = petRepository.getFromURL(id);
        Pet myPet = new Pet();
        myPet.setId(response.getId());
        myPet.setName(response.getName());
        myPet.setStatus(response.getStatus());

        return myPet;
    }

    public Transaction saveTransaction(Pet pet) {
        TransactionRequest myTransactionRequest = new TransactionRequest();
        myTransactionRequest.setId(pet.getId());
        myTransactionRequest.setName(pet.getName());
        myTransactionRequest.setStatus(pet.getStatus());

        PetResponse response = petRepository.saveTransaction(myTransactionRequest);
        Transaction myTransactionResponse = new Transaction();
        myTransactionResponse.setDateCreated(LocalDateTime.now());
        myTransactionResponse.setName(response.getName());
        myTransactionResponse.setStatus(response.getStatus());
        myTransactionResponse.setTransactionId(UUID.randomUUID().toString());

        return myTransactionResponse;
    }

}
