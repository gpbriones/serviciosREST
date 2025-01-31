package com.examen.demo.repository;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.examen.demo.model.request.TransactionRequest;
import com.examen.demo.model.response.PetResponse;

@Repository
public class PetRepository {

    private static final String URL_PET_GET = "https://petstore.swagger.io/v2/pet/";
    private static final String URL_PET_POST = "https://petstore.swagger.io/v2/pet";

    public PetResponse getFromURL(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        // carga de headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url = URL_PET_GET + id;
        System.err.println("servicio url:" + url);

        // PetResponse response = restTemplate.getForObject(url, PetResponse.class);
        PetResponse response = restTemplate.getForObject(url, PetResponse.class);
        return response;
    }

    public PetResponse saveTransaction(TransactionRequest request) {

        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        restTemplate.getMessageConverters().add(messageConverter);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TransactionRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<PetResponse> response = restTemplate.exchange(URL_PET_POST,
                HttpMethod.POST,
                entity,
                PetResponse.class);

        PetResponse pet = response.getBody();

        return pet;

    }

}
