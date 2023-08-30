package com.neosoft.poc.staticDynamicJsonFiltering.controller;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.neosoft.poc.staticDynamicJsonFiltering.dto.User;
import com.neosoft.poc.staticDynamicJsonFiltering.entity.UserEntity;
import com.neosoft.poc.staticDynamicJsonFiltering.response.AppResponse;
import com.neosoft.poc.staticDynamicJsonFiltering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class Usercontroller {

    @Autowired
    private UserService userService;
    @PostMapping("")
    public ResponseEntity<AppResponse> registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @GetMapping("")
    public EntityModel<ResponseEntity<AppResponse>> retrieveAllUsers(){
        ResponseEntity<AppResponse> appResponsefinal=userService.retrieveAllUsers();
        EntityModel<ResponseEntity<AppResponse>> entityModel=EntityModel.of(appResponsefinal);
        //can add links
        //using WebMvcLinkBuilder
        int id = 0;
        WebMvcLinkBuilder link= linkTo(methodOn(this.getClass()).retievesinleUserById(id));
        entityModel.add(link.withRel("retrieve_single_user"));
        return entityModel;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppResponse> retievesinleUserById(@PathVariable int id){
        return userService.retievesinleUserById(id);
    }

}
