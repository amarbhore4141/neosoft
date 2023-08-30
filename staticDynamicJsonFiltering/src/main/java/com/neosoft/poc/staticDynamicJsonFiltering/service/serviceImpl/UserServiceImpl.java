package com.neosoft.poc.staticDynamicJsonFiltering.service.serviceImpl;

import com.neosoft.poc.staticDynamicJsonFiltering.Utilities.ConstantUtilities;
import com.neosoft.poc.staticDynamicJsonFiltering.dto.User;
import com.neosoft.poc.staticDynamicJsonFiltering.entity.UserEntity;
import com.neosoft.poc.staticDynamicJsonFiltering.repo.UserRepo;
import com.neosoft.poc.staticDynamicJsonFiltering.response.AppResponse;
import com.neosoft.poc.staticDynamicJsonFiltering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public ResponseEntity<AppResponse> registerUser(User user) {
        UserEntity userEntity=UserEntity.builder().userName(user.getUsername()).name(user.getName()).password(user.getPassword()).city(user.getCity()).email(user.getEmail()).build();
        UserEntity savedUserEntity=userRepo.save(userEntity);
        AppResponse appResponse=AppResponse.builder().code(HttpStatus.CREATED.value()).message(ConstantUtilities.CREATED).data(savedUserEntity).build();
        return ResponseEntity.status(appResponse.getCode()).body(appResponse);
    }


    @Override
    public ResponseEntity<AppResponse> retrieveAllUsers() {
        List<UserEntity> userEntities =userRepo.findAll();
        List<UserEntity> userListWithIdAndName=userEntities.stream().map(n->UserEntity.builder().id(n.getId()).userName(n.getUserName()).build()).collect(Collectors.toList());
        AppResponse appResponse=AppResponse.builder().message("List of id and users").code(HttpStatus.OK.value()).data(userListWithIdAndName).build();
        return ResponseEntity.ok(appResponse);
    }

    @Override
    public ResponseEntity<AppResponse> retievesinleUserById(int id) {
        UserEntity userEntity=userRepo.findById(id).get();
        AppResponse appResponse=AppResponse.builder().code(HttpStatus.FOUND.value()).message("Following are the details for user: "+userEntity.getUserName()).data(userEntity).build();
        return ResponseEntity.status(appResponse.getCode()).body(appResponse);
    }
}
