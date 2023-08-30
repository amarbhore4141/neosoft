package com.neosoft.poc.staticDynamicJsonFiltering.service;


import com.neosoft.poc.staticDynamicJsonFiltering.dto.User;
import com.neosoft.poc.staticDynamicJsonFiltering.response.AppResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<AppResponse> registerUser(User user);

    ResponseEntity<AppResponse> retrieveAllUsers();

    ResponseEntity<AppResponse> retievesinleUserById(int id);
}
